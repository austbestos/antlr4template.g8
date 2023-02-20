import org.antlr.v4.runtime.*
import org.antlr.v4.runtime.tree.*

import java.io.FileInputStream
import java.io.InputStream

@main def main(args: String*): Unit = {
  val is: InputStream = args.length match
    case 0 => System.in
    case 1 => new FileInputStream(args.head)
    case _ => throw new Exception
  val input: ANTLRInputStream = new ANTLRInputStream(is)
  val lexer: $name$Lexer = new $name$Lexer(input)
  val tokens: CommonTokenStream = new CommonTokenStream(lexer)
  val parser: $name$Parser = new $name$Parser(tokens)
  val tree: ParseTree = parser.prog()
  System.out.println(tree.toStringTree(parser))
}
