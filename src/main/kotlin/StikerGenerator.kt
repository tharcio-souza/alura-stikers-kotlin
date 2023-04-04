import java.awt.BasicStroke
import java.awt.Color
import java.awt.Font
import java.awt.Graphics2D
import java.awt.Shape
import java.awt.font.TextLayout
import java.awt.geom.AffineTransform
import java.awt.image.BufferedImage
import java.io.File
import java.io.InputStream
import javax.imageio.ImageIO

class StikerGenerator {

    fun create(inputFile: InputStream, title: String, directory: String) {
        //Recebendo imagem e gerando base da figurinha
        val originalImage: BufferedImage = ImageIO.read(inputFile)
        val width = originalImage.width
        val height = originalImage.height
        val newHeight = height + 200
        val newImage = BufferedImage(width, newHeight, BufferedImage.TRANSLUCENT)

        //Criando imagem com a base transparente
        val graphics: Graphics2D = newImage.graphics as Graphics2D
        graphics.drawImage(originalImage, 0, 0, null)

        //Escrevendo texto centralizado na base
        val text = "TOP DEMAIS"
        val font = Font("Impact", Font.BOLD, 68)
        graphics.font = font
        graphics.color = Color.ORANGE

        val textWidth = graphics.fontMetrics.stringWidth(text)
        val textPositionX = (newImage.width / 2) - (textWidth / 2)
        val textPositionY = newHeight - 100
        graphics.drawString(text, textPositionX, textPositionY)

        val fontRenderContext = graphics.fontRenderContext
        val textLayout = TextLayout(text, font, fontRenderContext)

        val outline: Shape = textLayout.getOutline(null)
        val affineTransform: AffineTransform = graphics.transform

        affineTransform.translate(textPositionX.toDouble(), textPositionY.toDouble())
        graphics.transform = affineTransform
        val outlineStroke = BasicStroke(width * 0.004f)
        graphics.stroke = outlineStroke
        graphics.color = Color.BLACK
        graphics.draw(outline)
        graphics.clip = outline

        //Salvando arquivo na pasta output

        ImageIO.write(newImage, "png", File("$directory$title.png"))
    }
}