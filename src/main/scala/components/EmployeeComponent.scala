package components

import connection.{MySqlComponent, PostgresComponent, DBComponent}
import mappings.EmployeeTableMapping
import models.EmployeeModel

import scala.concurrent.Future

/**
  * Created by knoldus on 10/3/17.
  */

trait EmployeeComponent extends EmployeeTableMapping {
  this: DBComponent =>

  import driver.api._

  //  val db= Database.forConfig("myPostgresDB")
  def createTable = db.run(employeeTableQuery.schema.create)

  def insert(emp: EmployeeModel) = db.run {
    employeeTableQuery += emp
  }

  def delete(id: Int): Future[Int] = {
    val query = employeeTableQuery.filter(x => x.id === id)
    val action = query.delete
    db.run(action)
  }

  def update(emp: EmployeeModel, onId: Boolean): Future[Int] = {
    if (onId) {
      val query = employeeTableQuery.filter(x => x.id === emp.id)
      db.run(query.update(emp))
    }
    else {
      val query = employeeTableQuery.filter(x => x.name === emp.name)
      db.run(query.update(emp))
    }
  }

  def updateOrInsert(emp: EmployeeModel): Future[Int] = {

      val query = employeeTableQuery.insertOrUpdate(emp)
      employeeTableQuery+=emp
      db.run(query)
  }

  def getAll(): Future[List[EmployeeModel]] ={
    db.run(employeeTableQuery.to[List].result)
  }

}
  object EmployeeComponent extends EmployeeComponent with MySqlComponent