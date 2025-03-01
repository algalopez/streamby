package com.algalopez.streamby.backoffice_app.user.domain.model;

import java.util.UUID;
import lombok.Setter;
import lombok.experimental.Accessors;
import net.datafaker.Faker;

@Accessors(chain = true)
@Setter
class UserMother {

  private UUID id;
  private String alias;
  private String email;
  private Boolean active;

  public UserMother() {
    var faker = new Faker();
    this.id = UUID.randomUUID();
    this.alias = faker.text().text(10, 50);
    this.email = faker.internet().emailAddress();
    this.active = faker.bool().bool();
  }

  public User build() {
    return User.builder().id(id).alias(alias).email(email).active(active).build();
  }
}
