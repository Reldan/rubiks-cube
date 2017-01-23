package datamodel

case class Cube(facets: Array[Facet]) {}

object Cube {
  def fillCube() = {
    Cube(Array(
      Facet.ofColor('W'),
      Facet.ofColor('Y'),
      Facet.ofColor('R'),
      Facet.ofColor('B'),
      Facet.ofColor('O'),
      Facet.ofColor('G')
    ))
  }
}

case class Facet(rows: Array[Array[Char]]) {}

object Facet {
  def ofColor(color: Char) = {
    Facet( Array.fill(3){Array.fill(3){color} } )
  }
}

// Red
// Orange
// White
// Yellow
// Blue
// Green


//      | | | |
//      | |G| |
//      | | | |
//       - - -
//      | | | |
//      | |O| |
//      | | | |
//       - - -
//| | | | | | | | | |
//| |W| | |B| | | | |
//| | | | | | | | | |
//       - - -
//      | | | |
//      | |R| |
//      | | | |
//       - - -

