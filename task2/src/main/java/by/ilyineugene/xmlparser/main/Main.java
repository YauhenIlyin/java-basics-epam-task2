package by.ilyineugene.xmlparser.main;

import by.ilyineugene.xmlparser.entity.candy.CandyEntity;
import by.ilyineugene.xmlparser.evidence.XmlParserKeyWordName;
import by.ilyineugene.xmlparser.evidence.XmlPropertyKeyWordName;
import by.ilyineugene.xmlparser.exception.XmlParserAppException;
import by.ilyineugene.xmlparser.factory.ParserFactory;
import by.ilyineugene.xmlparser.parser.SaxEntityParser;
import by.ilyineugene.xmlparser.util.PropertiesXmlOperator;
import by.ilyineugene.xmlparser.validator.XmlXsdValidator;

import javax.xml.XMLConstants;
import java.util.HashSet;

public class Main {

    public static void main(String[] args) throws XmlParserAppException {
        PropertiesXmlOperator po = PropertiesXmlOperator.getInstance();
        String xmlFilePathName = po.getXmlFilePathName(XmlPropertyKeyWordName.CANDY.getNameValue());
        String xsdFilePathName = po.getXsdFilePathName(XmlPropertyKeyWordName.CANDY.getNameValue());
        XmlXsdValidator.isValid(XMLConstants.W3C_XML_SCHEMA_NS_URI, xmlFilePathName, xsdFilePathName);

        SaxEntityParser entityParser = (SaxEntityParser) ParserFactory.createParser(XmlParserKeyWordName.SAX);
        HashSet<CandyEntity> candyEntityHashSet = entityParser.parseXmlFile(XmlPropertyKeyWordName.CANDY);
        System.out.println(candyEntityHashSet.toString());
    }

}