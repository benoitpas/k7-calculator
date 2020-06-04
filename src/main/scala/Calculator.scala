object Calculator {
  // Root min square deviation
  def rms(l:List[Double]) = if (l.length==0) 0 else {
    val average = l.sum/ l.length
    def sqrDist(v: Double) = math.pow(v.toDouble - average, 2)
    val sumSquare = l.map(sqrDist).sum
    Math.sqrt(sumSquare)
  }

  // Root mean square deviation for the % step between cogs
  def rmsK7(cogs : List[Int]) = cogs match {
   case head::tail => {
      val diffs = (tail zip cogs.drop(-1)) map ((x,y) => ((x-y)/x.toDouble))
      rms(diffs)
    }
    case _ => 0.0
  }

  // Generate the possible 'steps' combinations
  def allCombinations(startStep:Int, nbTeeths:Int, nbSteps:Int) :List[List[Int]] = {
    if (nbSteps <= 0 || nbTeeths < startStep*nbSteps) List()
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

  // Convert list of steps to list of number of teeths of the cogs
  def toCogs(startCog : Int, steps:List[Int]) = {
    steps.foldLeft(List(startCog))(
      (cogs:List[Int], step:Int) => (cogs.head + step)::cogs
    ).reverse
  }

  // Returns an ordered list of K7 configuration with the RMS deviation for the
  // % step
  def listBestK7(startCog:Int, endCog:Int, nbCogs:Int) = {

    allCombinations(1, endCog-startCog, nbCogs - 1).map {
      (steps:List[Int]) => {
        val cogs = toCogs(startCog, steps)
        (rmsK7(cogs),cogs)
      }
    }.sortBy(_._1)
}

   
}