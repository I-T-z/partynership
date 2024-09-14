package com.example.partynership;

public class TagListItem {
    private String name;
    private String tagcontent;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTagcontent() {
        return tagcontent;
    }

    public void setTagcontent(String tagcontent) {
        this.tagcontent = tagcontent;
    }

    TagListItem(String _name, String _tagcontent){
        name = _name;
        tagcontent = _tagcontent;
    }

}
