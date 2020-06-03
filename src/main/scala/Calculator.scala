object Calculator {
  // Root min square
  def rms(l:List[Double]) = if (l.length==0) 0 else {
    val average = l.sum/ l.length
    def sqrDist(v: Double) = math.pow(v.toDouble - average, 2)
    val sumSquare = l.map(sqrDist).sum
    Math.sqrt(sumSquare)
  }
}