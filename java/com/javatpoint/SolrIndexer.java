package com.javatpoint;

import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.common.SolrInputDocument;

@SuppressWarnings("deprecation")
public class SolrIndexer {

    public static void main(String[] args) {
        // Solr server URL
        String solrUrl = "http://localhost:8983/solr/eclipse";

        // Create Solr client
        @SuppressWarnings("unused")
        CloseableHttpClient httpClient = HttpClients.createDefault();
        SolrClient solrClient = new HttpSolrClient.Builder(solrUrl).build();

        try {
            // Create Solr input document 1
            SolrInputDocument document1 = new SolrInputDocument();
            document1.addField("id", "1");
            document1.addField("catlog_id", "1");
            document1.addField("catlog_name", "white shirt");
            document1.addField("catlog_dis", "cotton");

            // Create Solr input document 2
            SolrInputDocument document2 = new SolrInputDocument();
            document2.addField("id", "2");
            document2.addField("catlog_id", "2");
            document2.addField("catlog_name", "black shirt");
            document2.addField("catlog_dis", "silk");

            // Send the documents to Solr for indexing
            solrClient.add(document1);
            solrClient.add(document2);

            // Commit the changes
            solrClient.commit();

            System.out.println("Documents indexed successfully in Solr.");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                // Close the Solr client
                solrClient.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
