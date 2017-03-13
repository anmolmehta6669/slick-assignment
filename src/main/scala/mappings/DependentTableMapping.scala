package mappings

import connection.DBComponent
import models.DependentModel
import slick.sql.SqlProfile.ColumnOption.Nullable

/**
  * Created by knoldus on 13/3/17.
  */
trait DependentTableMapping extends EmployeeTableMapping{this:DBComponent=>

    import driver.api._
    class DependentTable(tag: Tag) extends Table[DependentModel](tag, "dependent") {
      val empId= column[Int]("empId")
      val name=column[String]("pName")
      val relation=column[String]("relation")
      val age=column[Int]("age",Nullable)
      val employeeDependentFk = foreignKey("fk2",empId,employeeTableQuery)(_.id)

      def * = (empId, name, relation,age.?) <>(DependentModel.tupled, DependentModel.unapply)

    }
    val dependentTableQuery = TableQuery[DependentTable]
  }

