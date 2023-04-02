    import java.awt.Color
import java.awt.Font
import java.awt.Graphics2D
import java.awt.image.BufferedImage
import java.io.File
import java.io.InputStream
import javax.imageio.ImageIO

class StikerGenerator {

    fun create(inputFile : InputStream, title : String) {
        //Recebendo imagem e gerando base da figurinha
        val originalImage: BufferedImage = ImageIO.read(inputFile)
        val width = originalImage.width
        val height = originalImage.height
        val newHeight = height + 200
        val newImage = BufferedImage(width, newHeight, BufferedImage.TRANSLUCENT)

        //Criando imagem com a base transparente
        val graphics: Graphics2D = newImage.graphics as Graphics2D
        graphics.drawImage(originalImage,0,0, null)

        //Escrevendo texto centralizado na base
        val text = "TOP DEMAIS"
        val font = Font(Font.MONOSPACED,Font.BOLD, 68)
        graphics.font = font
        graphics.color = Color.ORANGE
        val textWidth = graphics.fontMetrics.stringWidth(text)
        val textPosition = (newImage.width/2) - (textWidth/2)
        graphics.drawString(text, textPosition, height + 100)

        //Salvando arquivo na pasta output
        ImageIO.write(newImage, "png", File("output/$title.png"))
    }
}