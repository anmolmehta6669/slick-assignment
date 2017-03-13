package connection

/**
  * Created by knoldus on 12/3/17.
  */
import slick.jdbc.PostgresProfile
trait PostgresComponent extends DBComponent{

    val driver = PostgresProfile

    import driver.api._

    val db: Database = PostgresComponent.connectionPool

  }

  private[connection] object PostgresComponent {

    import slick.jdbc.PostgresProfile.api._

    val connectionPool = Database.forConfig("myPostgresDB")

  }


