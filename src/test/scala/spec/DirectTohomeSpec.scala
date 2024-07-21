package test.scala.spec

import org.scalatest.FlatSpec
import org.scalatest._
import org.scalactic._

import main.scala.passbook.WalletBalance
import main.scala.operatorpackage.BasePackage
import main.scala.subscription.SubscriptionChannelServices

class DirectTohomeSpec extends FlatSpec {

  " WalletBalance " should " show intial balance as Rs 100 in first " in {

    var intBal = main.scala.driver.DirectToHome.currentBal

    assert(intBal === 100)

  }

  it should "show update balance of Rs 200 after first recharge of Rs 100" in {

    var wb = new WalletBalance()
    wb.recharge(100)
    var updatedBal = main.scala.driver.DirectToHome.currentBal

    assert(updatedBal === 200)

  }

  " BasePackage " should "contains all 3 channels Zee, Sony, Star Plus in Silver Pack" in {

    var bp = new BasePackage()
    var result = bp.silver()

    assert(

      result.contains("Zee") &&
      result.contains("Sony") &&
      result.contains("Star Plus"))

  }

  it should "contains all 5 channels Zee, Sony, Star Plus, Discovery, NatGeo in Gold pack" in {

    var bp = new BasePackage()
    var result = bp.gold()

    assert(

      result.contains("Zee") &&
      result.contains("Sony") &&
      result.contains("Star Plus") &&
      result.contains("Discovery") &&
      result.contains("NatGeo"))

  }

  " SubscriptionChannelServices " should "contains Zee, Sony, Star Plus, Discovery, NatGeo channel" in {

    var channels = new SubscriptionChannelServices()
    assert(
      channels.channelList.contains("Zee") &&
        channels.channelList.contains("Sony") &&
        channels.channelList.contains("Star Plus") &&
        channels.channelList.contains("Discovery") &&
        channels.channelList.contains("NatGeo"))
  }

  it should "contains LearnEnglish,LearnCooking Service" in {

    var services = new SubscriptionChannelServices()

    assert(
      services.serviceList.contains("LearnCooking") &&
        services.serviceList.contains("LearnEnglish"))

  }
}