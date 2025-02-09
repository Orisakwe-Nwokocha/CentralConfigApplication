package dev.orisha.central_config.controllers;


import java.util.List;

public class Response {

    private List<Data> propertySources;

    public List<Data> getPropertySources() {
        return propertySources;
    }

    public void setPropertySources(List<Data> propertySources) {
        this.propertySources = propertySources;
    }

    @Override
    public String toString() {
        return "Response{" +
                "propertySources=" + propertySources +
                '}';
    }

    public static class Source {

        private String message;

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        @Override
        public String toString() {
            return "Source{" +
                    "message='" + message + '\'' +
                    '}';
        }
    }

    public static class Data {

        private Source source;

        public Source getSource() {
            return source;
        }

        public void setSource(Source source) {
            this.source = source;
        }

        @Override
        public String toString() {
            return "Data{" +
                    "source=" + source +
                    '}';
        }
    }
}
