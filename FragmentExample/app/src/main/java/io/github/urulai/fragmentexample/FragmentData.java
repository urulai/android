package io.github.urulai.fragmentexample;

/**
 * Created by subramanian.n on 6/12/2018.
 */

public class FragmentData {
    private String name;
    private String description;

    public static final FragmentData[] items = {
            new FragmentData("Chinese", "Chinese cuisine is an important part of Chinese culture, " +
                    "which includes cuisine originating from the diverse regions of China, as well " +
                    "as from Chinese people in other parts of the world."),
            new FragmentData("French", "French cuisine consists of the cooking traditions " +
                    "and practices from France."),
            new FragmentData("Filipino", "Filipino cuisine is composed of the cuisines of 144 distinct " +
                    "ethno-linguistic groups found throughout the Philippine archipelago."),
            new FragmentData("Indonesian", "Indonesian cuisine is one of the most vibrant and colourful " +
                    "cuisines in the world, full of intense flavour. It is eclectic and diverse, in part " +
                    "because Indonesia is composed of approximately 6,000 populated islands of the total " +
                    "17,508 in the world's largest archipelago, with more than 300 ethnic groups " +
                    "calling Indonesia home."),
            new FragmentData("Japanese", "Japanese cuisine encompasses the regional and traditional " +
                    "foods of Japan, which have developed through centuries of social and economic changes."),
            new FragmentData("Korean", "Korean cuisine has evolved through centuries of social and political " +
                    "change. Originating from ancient agricultural and nomadic traditions in the Korean " +
                    "peninsula and southern Manchuria, Korean cuisine has evolved through a complex " +
                    "interaction of the natural environment and different cultural trends."),
            new FragmentData("New Mexican", "New Mexican cuisine is the cuisine of the Southwestern US " +
                    "state of New Mexico, the region is primarily known for its fusion of Pueblo Native " +
                    "American with Hispano Spanish and Mexican cuisine originating in Nuevo México."),
            new FragmentData("Middle Eastern",
                    "Middle Eastern cuisine is the cuisine of the various " +
                            "countries and peoples of the Middle East."),
            new FragmentData("Indian",
                    "Indian cuisine consists of a wide variety of " +
                            "regional and traditional cuisines native to the Indian subcontinent."),
            new FragmentData("Italian-American", "Italian-American cuisine is a style of Italian cuisine " +
                    "adapted throughout the United States."),
            new FragmentData("Pakistani", "Pakistani cuisine can be characterized by a blend of various " +
                    "regional cooking traditions of the Indian subcontinent, Central Asia as well as elements " +
                    "from its Mughal legacy"),
            new FragmentData("Sri Lankan", "Sri Lankan cuisine has been shaped by many historical, cultural " +
                    "and other factors. Contact with foreign traders who brought new food items, cultural " +
                    "influences from neighbouring countries as well as the local traditions of the country's " +
                    "ethnic groups among other things have all helped shape Sri Lankan cuisine."),
            new FragmentData("Turkish", "Turkish cuisine is largely the heritage of Ottoman cuisine, which " +
                    "can be described as a fusion and refinement of Central Asian, Middle Eastern, Eastern " +
                    "European and Balkan cuisines")
    };

    private FragmentData(String n, String d) {
        name = n;
        description = d;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        return name;
    }
}
