package com.kaltura.playkit.player;

public class MulticastSettings {

    // whether mulicast playback will use exo default config or app config
    private boolean useExoDefaultSettings = true;
    
    // experimental value to control whether to seek to default position if we get negative position on udp media load time 
    private boolean experimentalSeekToDefaultPosition = false;
    // maxPacketSize The maximum datagram packet size, in bytes.
    private int maxPacketSize = 3000;
    // socketTimeoutMillis The socket timeout in milliseconds. A timeout of zero is interpreted
    private int socketTimeoutMillis = 10000;
    //Modes for the extractor. One of MODE_MULTI_PMT, MODE_SINGLE_PMT, MODE_HLS
    private ExtractorMode extractorMode = ExtractorMode.MODE_MULTI_PMT;
    //The desired value of the first adjusted sample timestamp in microseconds - for no offset give MAX_LONG
    private long firstSampleTimestampUs;
    
    enum ExtractorMode {
        MODE_MULTI_PMT(0),
        MODE_SINGLE_PMT(1),
        MODE_HLS(2);

        public final int mode;
        ExtractorMode(int mode) {
            this.mode = mode;
        }
    }

    public MulticastSettings() {}

    public boolean getUseExoDefaultSettings() {
        return useExoDefaultSettings;
    }

    public boolean getExperimentalSeekToDefaultPosition() {
        return experimentalSeekToDefaultPosition;
    }

    public MulticastSettings setExperimentalSeekToStartOnMediaLoad(boolean experimentalSeekToDefaultPosition) {
        this.experimentalSeekToDefaultPosition = experimentalSeekToDefaultPosition;
        return this;
    }

    public int getMaxPacketSize() {
        return maxPacketSize;
    }

    public MulticastSettings setUseExoDefaultSettings(boolean useExoDefaultSettings) {
        this.useExoDefaultSettings = useExoDefaultSettings;
        return this;
    }

    public MulticastSettings setMaxPacketSize(int maxPacketSize) {
        this.maxPacketSize = maxPacketSize;
        this.useExoDefaultSettings = false;
        return this;
    }

    public int getSocketTimeoutMillis() {
        return socketTimeoutMillis;
    }

    public MulticastSettings setSocketTimeoutMillis(int socketTimeoutMillis) {
        this.socketTimeoutMillis = socketTimeoutMillis;
        this.useExoDefaultSettings = false;
        return this;
    }

    public ExtractorMode getExtractorMode() {
        return extractorMode;
    }

    public MulticastSettings setExtractorMode(ExtractorMode extractorMode) {
        if (extractorMode != null) {
            this.extractorMode = extractorMode;
        }
        this.useExoDefaultSettings = false;
        return this;
    }

    public long getFirstSampleTimestampUs() {
        return firstSampleTimestampUs;
    }

    public MulticastSettings setFirstSampleTimestampUs(long firstSampleTimestampUs) {
        this.firstSampleTimestampUs = firstSampleTimestampUs;
        return this;
    }
}
