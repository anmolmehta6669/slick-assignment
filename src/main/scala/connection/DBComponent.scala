package connection

/**
  * Created by knoldus on 12/3/17.
  */

import slick.jdbc.JdbcProfile

  trait DBComponent {

    val driver: JdbcProfile

    import driver.api._

    val db: Database

  }
