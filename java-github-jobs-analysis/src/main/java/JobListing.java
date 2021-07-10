import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class JobListing {

  public static void main(String[] args) throws IOException {
    File listingsJson = new File("./positions.json");
    List<HashMap<String, String>> jobs;
    jobs = new ArrayList<HashMap<String, String>>();
    
    ObjectMapper mapper = new ObjectMapper();
    ArrayList listings = mapper.readValue(listingsJson, ArrayList.class);

    List<Job> jobListings = new ArrayList<Job>();
    for(Map<String, String> thisListing : jobs){
      Job thisJob = new Job(thisListing.get("id"), thisListing.get("type"), thisListing.get("url"),
          thisListing.get("created_at"), thisListing.get("company"), thisListing.get("company_url"),
          thisListing.get("location"), thisListing.get("title"), thisListing.get("description"),
          thisListing.get("how_to_apply"), thisListing.get("company_logo"));
      jobListings.add(thisJob);
    }

    //calculate number of jobs per location
    //return the totals per city descending (highest first)


    //calculate number of jobs per company
    //output each company and number of jobs (no specific order)

    //write a new job
    //save it to a new json file called job.json
  }
}
