package components

import mappings.ProjectTableMapping
import models.{ProjectModel}

import scala.concurrent.Future
import connection.{MySqlComponent, DBComponent}

/**
  * Created by knoldus on 10/3/17.
  */
trait ProjectComponent extends ProjectTableMapping{ this: DBComponent=>
  import driver.api._
//  val db= Database.forConfig("myPostgresDB")
  def createTable= db.run(projectTableQuery.schema.create)

  def insert(proj:ProjectModel)= db.run{
    projectTableQuery += proj
  }

  def delete(id: Int): Future[Int] ={
    val query=projectTableQuery.filter(x=> x.empId===id)
    val action=query.delete
    db.run(action)
  }
  def update(proj: ProjectModel, onId: Boolean): Future[Int] = {
      val query = projectTableQuery.filter(x => x.empId === proj.empId)
      db.run(query.update(proj))
  }

  def updateOrInsert(proj: ProjectModel, onId: Boolean): Future[Int] = {

      val query = projectTableQuery.insertOrUpdate(proj)
      db.run(query)
  }

  def getAll(): Future[List[ProjectModel]] ={
    db.run(projectTableQuery.to[List].result)
  }
}

object ProjectComponent extends ProjectComponent with MySqlComponent
