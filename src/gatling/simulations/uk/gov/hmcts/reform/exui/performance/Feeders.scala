package uk.gov.hmcts.reform.exui.performance


object Feeders {


  val random = new scala.util.Random

  def randomString(alphabet: String)(n: Int): String =
    Stream.continually(random.nextInt(alphabet.size)).map(alphabet).take(n).mkString

  def randomAlphanumericString(n: Int) =
    randomString("abcdefghijklmnopqrstuvwxyz0123456789")(n)

  var generatedEmail = ""
  var generatedPassword = ""
  var generatedEmailForCase = ""
  var orgName = ""
  var appReferenceName = ""

  def generateEmailAddress() :String = {
    generatedEmail = ("exui-org" + randomAlphanumericString(6) + "@mailtest.gov.uk")
    //print("generated enail"+generatedEmail)
    generatedEmail
  }

  def generateUserEmailAddress() :String = {
    generatedEmail = ("exui-user" + randomAlphanumericString(6) + "@mailtest.gov.uk")
    //print("generated enail"+generatedEmail)
    generatedEmail
  }



  def generateOrganisationName() :String = {
    orgName = ("orgname-perftest" + randomAlphanumericString(4))
    orgName
  }

  def generateEmailForCase() :String = {
    generatedEmailForCase = ("exui_case" + randomAlphanumericString(6) + "@mailtest.gov.uk")
    //print("generated enail"+generatedEmail)
    generatedEmailForCase
  }

  def generateAppReferenceName() :String = {
    appReferenceName = ("case ref perftest" + randomAlphanumericString(6))
    appReferenceName
  }
  /*def generatePassword() :String = {
    generatedPassword = randomAlphanumericString(9)
    generatedPassword
  }*/

 /* def generateEmailAddress() :String = {
    generatedEmail = ("simulate-delivered-demo-3330@mailinator.com")
    generatedEmail
  }*/

  def generatePassword() :String = {
    generatedPassword = "Pass19word"
    generatedPassword
  }

  /*private def addDynamicData(): String = {
    generateEmailAddress()
   generatePassword()
   generateOrganisationName()
    var body =
      s"""{"fromValues":{"haveDXNumber":"dontHaveDX","orgName":"${orgName}","createButton":"Continue","officeAddressOne":"34","officeAddressTwo":"Philbeach Gardens","townOrCity":"London","county":null,"postcode":"SW5 9EY","PBAnumber1":null,"PBAnumber2":null,"haveDx":"no","haveSra":"no","firstName":"John","lastName":"Taylor","emailAddress":"${generatedEmail}","jurisdictions":[{"id":"SSCS"},{"id":"Divorce"},{"id":"Probate"},{"id":"Public Law"},{"id":"Bulk Scanning"},{"id":"Immigration & Asylum"},{"id":"Civil Money Claims"},{"id":"Employment"},{"id":"Family public law and adoption"},{"id":"Civil enforcement and possession"}]},"event":"continue"}""".stripMargin
    return body
  }*/


  val createDynamicDataFeeder = Iterator.continually(Map("generatedEmail" -> ({
    generateEmailAddress()
  }),"orgName" -> ({
    generateOrganisationName()
  })));
  /*val createDynamicDataFeeder = Iterator.continually(Map("generatedEmail" -> (generatedEmail), "generatedPassword" -> (generatedPassword), "generateOrganisationName" -> (orgName)));
*/

  val createCaseData = Iterator.continually(Map("caseEmail" -> ({
    generateEmailForCase()
  }),"appRef" -> ({
    generateAppReferenceName()
  })));

  val createDynamicUserDataFeeder = Iterator.continually(Map("generatedUserEmail" -> ({
    generateUserEmailAddress()
  })));



}



