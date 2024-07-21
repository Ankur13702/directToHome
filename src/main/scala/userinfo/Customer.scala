package main.scala.userinfo

class Customer {

  private var email = ""
  private var phone = ""

  def addCustomerDetails(mail: String, contactno: String) {

    this.email = mail
    this.phone = contactno

    println("Email and Phone updated successfully")

  }

}