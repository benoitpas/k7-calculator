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

def allCombinations(startStep:Int, nbTeeths:Int, nbCogs:Int) :List[List[Int]] = {
  if (nbCogs == 0) List() 
  else if (nbCogs == 1) List(List(nbTeeths))
  else
    {
    val maxStep = math.max(startStep,(nbTeeths / nbCogs).toInt)
    for( 
      step <-  (startStep to maxStep).toList;
      combination <- allCombinations(step, nbTeeths-step, nbCogs-1))
    yield (step::combination)
  }
}

def findBestK7(startCog:Int, endCog:Int, nbCogs:Int) = {

  allCombinations(1, endCog-startCog, nbCogs)
}

findBestK7(12,12,1).toList
findBestK7(12,13,1).toList
findBestK7(12,24,4).toList
(1 to 1).toList