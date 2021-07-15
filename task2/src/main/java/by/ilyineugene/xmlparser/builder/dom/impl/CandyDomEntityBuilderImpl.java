package by.ilyineugene.xmlparser.builder.dom.impl;

import by.ilyineugene.xmlparser.builder.EntityBuilder;
import by.ilyineugene.xmlparser.builder.dom.DomEntityBuilder;
import by.ilyineugene.xmlparser.entity.candy.CandyEntity;
import by.ilyineugene.xmlparser.evidence.candy.XmlCandyTag;
import by.ilyineugene.xmlparser.exception.XmlParserAppException;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.HashSet;

public class CandyDomEntityBuilderImpl extends EntityBuilder implements DomEntityBuilder {

    private HashSet<CandyEntity> candyHashSet;
    private boolean buildCompleted = false;
    private Document doc;

    public CandyDomEntityBuilderImpl() {
    }

    public HashSet buildEntityHashSet(Document doc) {
        this.doc = doc;
        Node rootNode = doc.getDocumentElement();
        NodeList nodeList = rootNode.getChildNodes();
        int entityCount = nodeList.getLength();
        Node node;
        for (int i = 0; i < entityCount; i++) {
            node = nodeList.item(i);
            CandyEntity candyEntity = buildEntity(node);
            
        }
    }

    private CandyEntity buildEntity(Node node) {
        CandyEntity candyEntity = new CandyEntity();
        NodeList nodeList = node.getChildNodes();

    }

    public HashSet getEntityHashSet() throws XmlParserAppException {
        if (buildCompleted == false) {
            throw new XmlParserAppException("CandyDomEntityBuilderImpl.class getEntityHashSet(): build is not complete. error..");
        }
        return this.candyHashSet;
    }
}
