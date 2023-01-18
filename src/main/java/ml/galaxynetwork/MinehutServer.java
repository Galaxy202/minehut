package ml.galaxynetwork;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MinehutServer {
    private final JSONObject server;

    /**
     * Sets the variable in this file to your parameter
     */
    public MinehutServer(String name) {
        this.server = getServer(name);
    }

    /**
     * @return The Minehut Server's JSONObject
     */
    private JSONObject getServer(String name) {
        try {
            URL url = new URL("https://api.minehut.com/server/" + name + "?byName=true");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            int response_code = connection.getResponseCode();
            if (response_code != 200) {
                System.out.println("Minehut Server couldn't be found.");
            } else {
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(connection.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();
                JSONObject Data = new JSONObject(response.toString());
                return Data.getJSONObject("server");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    // Get Functions

    /**
     * Gets all Categories using the Minehut's API
     * @return Categories in JSONArray
     */
    public JSONArray getCategories() {
        if (!(server.has("categories"))) return null;
        return server.getJSONArray("categories");
    }


    /**
     * Gets all Inherited Categories using the Minehut's API
     * @return Inherited Categories in JSONArray
     */
    public JSONArray getInheritedCategories() {
        if (!(server.has("inheritedCategories"))) return null;
        return server.getJSONArray("inheritedCategories");
    }

    /**
     * Gets all Purchased Icons using the Minehut's API
     * @return Purchased Icons in JSONArray
     */
    public JSONArray getPurchasedIcons() {
        if (!(server.has("purchased_icons"))) return null;
        return server.getJSONArray("purchased_icons");
    }

    /**
     * Gets how much backup slots the server has. Can
     * @return Backup Slots in int
     */
    public int getBackupSlots() {
        if (!(server.has("backup_slots"))) return -1;
        return server.getInt("backup_slots");
    }


    /**
     * Get the Minehut Server's Version Type like PAPER
     * @return The Server Version Type like PAPER in String
     */
    public String getServerVersionType() {
        if (!(server.has("server_version_type"))) return null;
        return server.getString("server_version_type");
    }

    /**
     * Get all Connected Servers
     * @return A JSONArray of all connected server else if proxy is off will return an empty list
     */
    public JSONArray getConnectedServers() {
        if (!(server.has("connectedServers"))) return null;
        return server.getJSONArray("connectedServers");
    }

    /**
     * Get the Server's ID
     * @return The ID of a server in String
     */
    public String getId() {
        if (!(server.has("_id"))) return null;
        return server.getString("_id");
    }

    /**
     * Get the MOTD of a Minehut Server
     * @return The MOTD of a Minehut Server in String
     */
    public String getMOTD() {
        if (!(server.has("motd"))) return null;
        return server.getString("motd");
    }

    /**
     * Get the Minehut Server's Plan
     * @return The Minehut Server Plan in String
     */
    public String getServerPlan() {
        if (!(server.has("server_plan"))) return null;
        return server.getString("server_plan");
    }

    /**
     * Get where the server storage is in
     * @return The Storage Node your server is in, String
     */
    public String getStorageNode() {
        if (!(server.has("storage_node"))) return null;
        return server.getString("storage_node");
    }

    /**
     * Get the Server Owner's ID
     * @return The Owner's ID in String
     */
    public String getOwnerID() {
        if (!(server.has("owner"))) return null;
        return server.getString("owner");
    }


    /**
     * Get the Server's name
     * @return Server name in String
     */
    public String getName() {
        if (!(server.has("name"))) return null;
        return server.getString("name");
    }

    public String getLowercaseName() {
        if (!(server.has("name_lower"))) return null;
        return server.getString("name_lower");
    }

    /**
     * Get the Creation's Timestamp
     * @return The Creation's Timestamp in Long
     */
    public Long getCreation() {
        if (!(server.has("creation"))) return null;
        return server.getLong("creation");
    }

    /**
     * Get which platform a Minehut Server is on. Mostly Java
     * @return The platform a Minehut Server is on, String
     */
    public String getPlatform() {
        if (!(server.has("platform"))) return null;
        return server.getString("platform");
    }

    /**
     * Get the Minehut Server's Credits Per Second
     * @return Credits Per Second in int
     */
    public int getCPD() {
        if (!(server.has("credits_per_day"))) return -1;
        return server.getInt("credits_per_day");
    }


    /**
     * Get the port of a Minehut Server
     * @return The port of the Minehut Server in int
     */
    public int getPort() {
        if (!(server.has("port"))) return -1;
        return server.getInt("port");
    }

    /**
     * Get the Long of the last time the server was online
     * @return The Last Online's Timestamp in Long
     */
    public Long getLastOnline() {
        if (!(server.has("last_online"))) return null;
        return server.getLong("last_online");
    }

    /**
     * Get Server's Max Players
     * @return Server's Max Players in int
     */
    public int getMaxPlayers() {
        if (!(server.has("maxPlayers"))) return -1;
        return server.getInt("maxPlayers");
    }


    /**
     * Get the Raw Plan in String
     * @return The Raw Plan in String
     */
    public String getRawPlan() {
        if (!(server.has("rawPlan"))) return null;
        return server.getString("rawPlan");
    }

    /**
     * Get the Active Server Plan
     * @return The Active Server plan in String
     */
    public String getActiveServerPlan() {
        if (!(server.has("activeServerPlan"))) return null;
        return server.getString("activeServerPlan");
    }

    // Is Functions

    /**
     * Check if the server is visible or not.
     * @return True if server is visible else False if server isn't visible
     */
    public boolean isVisible() {
        return server.getBoolean("visibility");
    }

    /**
     * Check if the server is a proxy or not.
     * @return True if the server is a proxy else False if not
     */
    public boolean isProxy() {
        return server.getBoolean("proxy");
    }

    /**
     * Check if a server is suspended or not.
     * @return True if the server is suspended from Minehut else not
     */
    public boolean isSuspended() {
        return server.getBoolean("suspended");
    }

    /**
     * Check if Server is using cosmetics
     * @return True if server uses Cosmetics else False if cosmetics is disabled
     */
    public boolean isUsingCosmetics() {
        if (!(server.has("using_cosmetics"))) return false;
        else return server.getBoolean("using_cosmetics");
    }

    /**
     * Check if the server is online or not
     * @return True if the server is online else False if server is offline
     */
    public boolean isOnline() {
        return server.getBoolean("online");
    }

    // Has Functions

    /**
     * Checks if the server has categories
     * @return True if server has category else false if categories doesn't exist
     */
    public boolean hasCategories() {
        return server.has("categories");
    }
    /**
     * Checks if the server has inherited categories
     * @return True if server has inherited categories else false if inherited categories doesn't exist
     */
    public boolean hasInheritedCategories() {
        return server.has("inheritedCategories");
    }

    /**
     * Checks if the server has purchased icons
     * @return True if server has Purchased icons else false if Purchased icons doesn't exist
     */
    public boolean hasPurchasedIcons() {
        return server.has("purchased_icons");
    }
    /**
     * Checks if the server has Backup Slots
     * @return True if server has backup slots else false if backup slots doesn't exist
     */
    public boolean hasBackupSlots() {
        return server.has("backup_slots");
    }
    /**
     * Checks if the server has server version type
     * @return True if server has Server Version Type else false if Server Version Type doesn't exist
     */
    public boolean hasServerVersionType() {
        return server.has("server_version_type");
    }
    /**
     * Checks if the server has Connected Servers
     * @return True if server has Connected Servers else false if Connected Servers doesn't exist
     */
    public boolean hasConnectedServers() {
        return server.has("connectedServers");
    }
    /**
     * Checks if the server has an id
     * @return True if server has an id else false if id doesn't exist
     */
    public boolean hasId() {
        return server.has("_id");
    }
    /**
     * Checks if the server has a MOTD
     * @return True if server has MOTD else false if MOTD doesn't exist
     */
    public boolean hasMOTD() {
        return server.has("motd");
    }
    /**
     * Checks if the server has a Server Plan
     * @return True if server has a Server Plan else false if a Server Plan doesn't exist
     */
    public boolean hasServerPlan() {
        return server.has("server_plan");
    }
    /**
     * Checks if the server has Storage Node
     * @return True if server has Storage Node else false if Storage Node doesn't exist
     */
    public boolean hasStorageNode() {
        return server.has("storage_node");
    }
    /**
     * Checks if the server has an Owner ID
     * @return True if server has an Owner ID else false if an Owner ID doesn't exist
     */
    public boolean hasOwnerID() {
        return server.has("owner");
    }
    /**
     * Checks if the server has a name
     * @return True if server has a name else false if a name doesn't exist
     */
    public boolean hasName() {
        return server.has("name");
    }
    /**
     * Checks if the server has a lowercase name
     * @return True if server has a lowercase name else false if a lowercase name doesn't exist
     */
    public boolean hasLowercaseName() {
        return server.has("name_lower");
    }
    /**
     * Checks if the server has creation
     * @return True if server has a Creation else false if a Creation doesn't exist
     */
    public boolean hasCreation() {
        return server.has("creation");
    }
    /**
     * Checks if the server has Platform
     * @return True if server has Platform else false if Platform doesn't exist
     */
    public boolean hasPlatform() {
        return server.has("platform");
    }
    /**
     * Checks if the server has CPD
     * @return True if server has CPD else false if CPD doesn't exist
     */
    public boolean hasCPD() {
        return server.has("credits_per_day");
    }
    /**
     * Checks if the server has a port
     * @return True if server has a port else false if a port doesn't exist
     */
    public boolean hasPort() {
        return server.has("port");
    }
    /**
     * Checks if the server has Last online
     * @return True if server has Last Online else false if Last Online doesn't exist
     */
    public boolean hasLastOnline() {
        return server.has("last_online");
    }
    /**
     * Checks if the server has max player
     * @return True if server has max player else false if max player doesn't exist
     */
    public boolean hasMaxPlayers() {
        return server.has("maxPlayers");
    }
    /**
     * Checks if the server has a raw plan
     * @return True if server has a raw plan else false if a raw plan doesn't exist
     */
    public boolean hasRawPlan() {
        return server.has("rawPlan");
    }
    /**
     * Checks if the server has visibility
     * @return True if server has visibility else false if visibility doesn't exist
     */
    public boolean hasVisible() {
        return server.has("visibility");
    }
    /**
     * Checks if the server has proxy
     * @return True if server has proxy else false if proxy doesn't exist
     */
    public boolean hasProxy() {
        return server.has("proxy");
    }
    /**
     * Checks if the server has suspended
     * @return True if server has Suspended else false if Suspended doesn't exist
     */
    public boolean hasSuspended() {
        return server.has("suspended");
    }
    /**
     * Checks if the server has Using Cosmetics
     * @return True if server has Using Cosmetics else false if Using Cosmetics doesn't exist
     */
    public boolean hasUsingCosmetics() {
        return server.has("using_cosmetics");
    }
    /**
     * Checks if the server has Online
     * @return True if server has Online else false if Online doesn't exist
     */
    public boolean hasOnline() {
        return server.has("online");
    }
}