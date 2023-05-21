package number

import scala.util.Random

object ApproximatePi {

  private val random = new Random(System.currentTimeMillis())

  // Monte-Carlo Algorithm
  def approximatePi(points: Int): Double = {
    val pointsInsideTheCircle = (1 to points).map { _ =>
      val x = random.nextDouble()
      val y = random.nextDouble()

      x * x + y * y
    }.count(distance => distance < 1)
    pointsInsideTheCircle * 4.0 / points
  }

}
