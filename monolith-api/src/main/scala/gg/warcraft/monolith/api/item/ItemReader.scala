package gg.warcraft.monolith.api.item

class ItemReader {

}

/*
public class SimpleItemReader implements ItemReader {
    private final StringUtils stringUtils;
    private final Item item;

    @Inject
    public SimpleItemReader(StringUtils stringUtils,
                            @Assisted @Nullable Item item) {
        this.stringUtils = stringUtils;
        this.item = item;
    }

    @Override
    public String getType() {
        if (item == null) {
            return null;
        }

        List<String> lore = item.getTooltip();
        if (lore.size() == 0) {
            return null;
        }

        if (lore.size() == 1 || stringUtils.removeChatCodes(lore.get(1)).isEmpty()) {
            return stringUtils.removeChatCodes(lore.get(0));
        }
        return null;
    }

    @Override
    public int getAttribute(Attribute attribute) {
        if (item == null) {
            return 0;
        }

        List<String> lore = item.getTooltip();
        for (String line : lore) {
            if (line.contains(attribute.getName())) {
                String rawLine = stringUtils.removeChatCodes(line);
                String onlyNumbers = rawLine.replaceAll("[\\D]", "");
                try {
                    return Integer.parseInt(onlyNumbers);
                } catch (NumberFormatException ex) {
                    return 0;
                }
            }
        }
        return 0;
    }
}

 */