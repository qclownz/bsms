package net.gxu.bsms.test;

import net.gxu.bsms.service.EntryRecordService;

public class EntryRecordTest {
    public static void main(String[] args) {

        EntryRecordService entryRecordService = new EntryRecordService();
        System.out.println(entryRecordService.deleteEntryRecordById(1));

    }
}
