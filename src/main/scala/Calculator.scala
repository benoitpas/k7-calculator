object Calculator {
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

  def allCombinations(startStep:Int, nbTeeths:Int, nbSteps:Int) :List[List[Int]] = {
    if (nbSteps == 0) List() 
    else if (nbSteps == 1) List(List(nbTeeths))
    else
    {
      val maxStep = math.max(startStep,(nbTeeths / nbSteps).toInt)
      for( 
        step <-  (startStep to maxStep).toList;
        combination <- allCombinations(step, nbTeeths-step, nbSteps-1))
      yield (step::combination)
    }
  }
}