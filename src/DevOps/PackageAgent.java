package DevOps;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PackageAgent {

    // List with Packages
    public List<PackageAgent> packages = new ArrayList<PackageAgent>();

    public void build() {

        // If Has PackageAgent
        if (this.packages.size() > 0) {

            // For Each PackageAgent
            for (Iterator<PackageAgent> p = this.packages.iterator(); p.hasNext();) {


                /////////////////////
                PackageAgent aPackageAgent = p.next();

                // If PackageAgent Exists
                if (aPackageAgent != null) {

                    // Install PackageAgent
                    //aPackageAgent.install();
                }
                ///////////////////////
            }
        }
    }
}
