package visualisation

import datamodel.{Cube, Facet}

object Visualizer {

  val halfWidth = 80d
  val halfHeight = 80d
  val canvasHeight = 800
  val canvasWidth = 1300

  val charToColor = Map(
    'W' -> StdDraw.WHITE,
    'R' -> StdDraw.RED,
    'Y' -> StdDraw.YELLOW,
    'O' -> StdDraw.ORANGE,
    'G' -> StdDraw.GREEN,
    'B' -> StdDraw.BLUE
  )

  def drawFacet(facet: Facet, xOffset: Double, yOffset: Double): Unit = {
    val color = charToColor(facet.rows.head.head)
    facet.rows.zipWithIndex.foreach{
      case(row, rowIndex) =>
        row.zipWithIndex.foreach {
          case(col, colIndex) =>
            StdDraw.setPenColor(color)
            StdDraw.filledSquare(xOffset + (colIndex - 1) * 2 * halfWidth / 3,
                                 yOffset + (rowIndex - 1) * 2 * halfHeight / 3,
                                 halfWidth / 3)
        }
    }



    StdDraw.setPenColor(StdDraw.BLACK)
    StdDraw.square(xOffset, yOffset, halfWidth)
    StdDraw.line(xOffset + halfWidth * 1 / 3, yOffset - halfHeight, xOffset + halfWidth * 1 / 3, yOffset + halfHeight)
    StdDraw.line(xOffset - halfWidth * 1 / 3, yOffset - halfHeight, xOffset - halfWidth * 1 / 3, yOffset + halfHeight)
    StdDraw.line(xOffset - halfWidth, yOffset - halfHeight * 1 / 3, xOffset + halfWidth, yOffset - halfHeight * 1 / 3)
    StdDraw.line(xOffset - halfWidth, yOffset + halfHeight * 1 / 3, xOffset + halfWidth, yOffset + halfHeight * 1 / 3)
  }

  def visualize(cube: Cube) = {
    StdDraw.setCanvasSize(canvasWidth, canvasHeight)
    StdDraw.setXscale(0, canvasWidth)
    StdDraw.setYscale(0, canvasHeight)
    StdDraw.setPenColor(StdDraw.LIGHT_GRAY)
    StdDraw.filledRectangle(canvasWidth / 2, canvasHeight / 2, canvasWidth / 2, canvasHeight / 2)
    val radius = 0.48d
    StdDraw.setPenColor(StdDraw.LIGHT_GRAY)
    StdDraw.filledSquare(0.5, 0.5, radius)
    StdDraw.setPenColor(StdDraw.ORANGE)

    StdDraw.setPenRadius(0.01)

    drawFacet(cube.facets.head, halfWidth * 2 , 4 * halfHeight)
    drawFacet(cube.facets(1), halfWidth * 6 , 4 * halfHeight)

    cube.facets.drop(2).zipWithIndex.foreach{
      case(facet, index) => drawFacet(facet, halfWidth * 4, 2 * halfHeight + halfHeight * 2 * index)
    }

    StdDraw.text(900, 700, "Parameters")

    StdDraw.show(1)
  }
}
