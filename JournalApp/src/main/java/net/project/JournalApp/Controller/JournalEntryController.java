package net.project.JournalApp.Controller;

import net.project.JournalApp.Entity.JournalEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
@RestController
@RequestMapping("/jouranl")
public class JournalEntryController {
    private HashMap <Long, JournalEntity> entry = new HashMap<Long, JournalEntity>();
    @GetMapping
    public ArrayList<JournalEntity> getJournalEntries() {
        return new ArrayList<JournalEntity>(entry.values());
    }
    @PostMapping
    public void

}
