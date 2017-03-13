package components

import connection.{MySqlComponent, DBComponent}
import mappings.DependentTableMapping
import models.DependentModel

import scala.concurrent.Future

/**
  * Created by knoldus on 13/3/17.
  */
trait DependentComponent extends DependentTableMapping {
  this: DBComponent =>

  import driver.api._

  //  val db= Database.forConfig("myPostgresDB")
  def createTable = db.run(dependentTableQuery.schema.create)

  def insert(dependent: DependentModel) = db.run {
    dependentTableQuery += dependent
  }

  def delete(id: Int): Future[Int] = {
    val query = dependentTableQuery.filter(x => x.empId === id)
    val action = query.delete
    db.run(action)
  }

  def update(dependent: DependentModel, onId: Boolean): Future[Int] = {
    val query = dependentTableQuery.filter(x => x.empId === dependent.empId)
    db.run(query.update(dependent))
  }

  def updateOrInsert(dependent: DependentModel, onId: Boolean): Future[Int] = {

      val query = dependentTableQuery.insertOrUpdate(dependent)
      dependentTableQuery+=dependent
      db.run(query)
  }

  def getAll(): Future[List[DependentModel]] = {
    db.run(dependentTableQuery.to[List].result)
  }
}

object DependentComponent extends DependentComponent with MySqlComponent
