import java.io.File;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Profile {
    public String first;
    public String last;
    public Integer grade;

    Profile(String first, String last, Integer grade) {
        this.first = first;
        this.last = last;
        this.grade = grade;
    
    }
}
