package mappings

import connection.DBComponent
import models.{ProjectModel}

/**
  * Created by knoldus on 10/3/17.
  */
trait ProjectTableMapping extends EmployeeTableMapping{this:DBComponent=>

    import driver.api._
   class ProjectTable(tag: Tag) extends Table[ProjectModel](tag, "project") {
    val empId= column[Int]("empId")
     val pName=column[String]("pName")
      val employeeProjectFk = foreignKey("fk1",empId,employeeTableQuery)(_.id)

      def * = (empId, pName) <>(ProjectModel.tupled, ProjectModel.unapply)

    }
    val projectTableQuery = TableQuery[ProjectTable]
  }

