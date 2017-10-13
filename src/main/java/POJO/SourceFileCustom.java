package POJO;

import java.util.List;

public class SourceFileCustom extends SourceFile{
    private List<SourceFile> list;

    public List<SourceFile> getList() {
        return list;
    }

    public void setList(List<SourceFile> list) {
        this.list = list;
    }
}
