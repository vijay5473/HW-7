package edu.umb.cs680.hw07;
import java.time.LocalDateTime;
import java.util.LinkedList;

public class Directory extends FSElement{
    
    public Directory(Directory parent, String name, int size, LocalDateTime creationtime) {
        super(parent, name, size, creationtime);
        if(parent!=null){
            parent.appendSubDirectory(this);
        }
        
    }
    
    LinkedList<FSElement> children = new LinkedList<FSElement>();
    LinkedList<Directory> directory = new LinkedList<Directory>();
    LinkedList<File> file = new LinkedList<File>();
    
    public LinkedList<FSElement> getChildren(){
        return this.children;
    }
    
    public void appendChild(FSElement child ){
        this.children.add(child);
    }
    
    public int countChildren(){
        return children.size();
    }
    
    public void  appendSubDirectory(Directory sb){
        this.directory.add(sb);
    }
    
    public LinkedList<Directory> getSubDirectories(){
        return this.directory;
    }
    
    public void appendFile(File f){
        this.file.add(f);
    }
    
    public LinkedList<File> getFiles(){
        return this.file;
    }
    
    public int getTotalsize(){
        FSElement dir= this;
        Directory d=(Directory) dir;
        int i;
        int z=0;
        for(i=0;i<d.getChildren().size();i++){
            z=z+d.getChildren().get(i).getSize();
        }
        return z;
    }
    
}

