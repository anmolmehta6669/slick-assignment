package mappings

import connection.DBComponent
import models.EmployeeModel
/**
  * Created by knoldus on 10/3/17.
  */

trait EmployeeTableMapping { this: DBComponent=>
  import driver.api._

  class EmployeeTable(tag: Tag) extends Table[EmployeeModel](tag, "employee") {

    val id = column[Int]("id",O.PrimaryKey)
    val name = column[String]("name")

    def * = (id, name) <>(EmployeeModel.tupled, EmployeeModel.unapply)

  }
  val employeeTableQuery = TableQuery[EmployeeTable]
}
