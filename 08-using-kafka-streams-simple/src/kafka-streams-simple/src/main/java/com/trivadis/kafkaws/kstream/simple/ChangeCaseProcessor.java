package com.trivadis.kafkaws.kstream.simple;

import org.apache.kafka.streams.processor.api.Processor;
import org.apache.kafka.streams.processor.api.ProcessorContext;
import org.apache.kafka.streams.processor.api.Record;

public class ChangeCaseProcessor implements Processor<Void, String, Void, String> {
    private ProcessorContext<Void,String> context = null;
    private boolean toUpperCase = true;

    public ChangeCaseProcessor(boolean toUpperCase) {
        this.toUpperCase = toUpperCase;
    }

    @Override
    public void init(ProcessorContext<Void, String> context) {
        this.context = context;
    }

    @Override
    public void process(Record<Void, String> record) {
        System.out.println("(Processor API) " + record.value());
        String newValue = record.value();

        if (toUpperCase) {
            newValue = record.value().toUpperCase();
        } else {
            newValue = record.value().toLowerCase();
        }
        Record<Void, String> newRecord = new Record<>(record.key(), newValue, record.timestamp());
        context.forward(newRecord);
    }

    @Override
    public void close() {
        // no special clean up needed in this example
    }
}