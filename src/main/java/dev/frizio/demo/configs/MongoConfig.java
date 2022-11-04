package dev.frizio.demo.configs;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;


import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.ServerApi;
import com.mongodb.ServerApiVersion;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

import lombok.RequiredArgsConstructor;


@Configuration
@Profile("dev")
@RequiredArgsConstructor
public class MongoConfig extends AbstractMongoClientConfiguration  {

   private final Environment env;

   @Value("${MONGODBNAME}")
   private String MONGODBNAME;


   @Override
   protected String getDatabaseName() {
      return MONGODBNAME;
   }
   
  @Override
  @Bean
  public MongoClient mongoClient() {
    System.out.println("*********************** Init MongoClient ***********************");
    final String CONNECTION_STRING = env.getProperty("FRIZIO_MONGODB_URI", String.class);
    ConnectionString connectionString = new ConnectionString(CONNECTION_STRING);
    MongoClientSettings settings = MongoClientSettings.builder()
            .applyConnectionString(connectionString)
            .serverApi(ServerApi.builder()
                .version(ServerApiVersion.V1)
                .build())
            .build();
    MongoClient mongoClient = MongoClients.create(settings);
    System.out.println("*********************************************************************");
    return mongoClient;
  }

}
