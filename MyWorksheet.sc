// Root min square
def rms(l:List[Double]) = if (l.length==0) 0 else {
  val average = l.sum/ l.length
  def sqrDist(v: Double) = math.pow(v.toDouble - average, 2)
  val sumSquare = l.map(sqrDist).sum
  Math.sqrt(sumSquare)
}

def rmsK7(cogs : List[Int]) = cogs match {
  case head::tail => {
    val diffs = (tail zip cogs.drop(-1)) map ((x,y) => ((x-y)/x.toDouble))
    rms(diffs)
  }
  case _ => 0.0
}

val l = List(12,14,16,20,24)
rmsK7(l)
val l2 =List(12,14,17,20,24)
rmsK7(l2)
val l3 =List(12,15,18,21,24)
rmsK7(l3)

def findBestK7(startCog:Int, endCog:Int, nbCogs:Int) = {
  def allCombinations(startCog:Int, endCog:Int, nbCogs:Int, initialStep:Int) :List[List[Int]] = {
    if (startCog > endCog || (endCog - startCog + 1) < nbCogs * initialStep || nbCogs == 0) List() else {
      val maxStep = ((endCog - startCog) / (initialStep * (nbCogs -1))).toInt
      for( 
        step <-  (initialStep to maxStep).toList;
        combination <- allCombinations(startCog + step, endCog, nbCogs-1, step))
      yield (startCog::combination)
    }
  }
  allCombinations(startCog, endCog, nbCogs, 1)
}

findBestK7(12,12,1).toList
