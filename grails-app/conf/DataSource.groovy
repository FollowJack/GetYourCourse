dataSource {
    pooled = true
    driverClassName = "com.mysql.jdbc.Driver"
    username = "root"
    password = "groovy"
    dbCreate = "update"
}
hibernate {
    cache.use_second_level_cache=false
    cache.use_query_cache=false
    //cache.provider_class='com.opensymphony.oscache.hibernate.OSCacheProvider'
}
// environment specific settings
environments {
    development {
        dataSource {
            logginsSQL = true
            pooled = "false"
            dbCreate = "update" // one of 'create', 'create-drop','update'
            url = "jdbc:mysql://127.0.0.1/getyourcourse"
        }
    }
    test {
        dataSource {
            dbCreate = "update"
            url = "jdbc:mysql://127.0.0.1/getyourcourse"
        }
    }
    production {
        dataSource {
            dbCreate = "update"
            url = "jdbc:mysql://127.0.0.1/getyourcourse"
        }
    }
}