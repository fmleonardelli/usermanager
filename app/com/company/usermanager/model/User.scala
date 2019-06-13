package com.company.usermanager.model

case class User(val userName: String, val partyId : Long) {

}

object User {

  def apply(userName : String, partyId : Long) : User = new User(userName, partyId)
}
