package connection

/**
  * Created by knoldus on 12/3/17.
  */

import slick.jdbc.MySQLProfile

trait MySqlComponent extends DBComponent{

  val driver = MySQLProfile

  import driver.api._

  val db: Database = MySqlComponent.connectionPool

}

private[connection] object MySqlComponent {

  import slick.jdbc.MySQLProfile.api._

  val connectionPool = Database.forConfig("mysql")


}
