package com.nenad.myapp.Devices;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
     public class web {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long id;

        private String SN;

        private String Location;

        private String Model;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getSN() {
            return SN;
        }

        public void setSN(String SN) {
            this.SN = SN;
        }

        public String getLocation() {
            return Location;
        }

        public void setLocation(String location) {
            this.Location = location;
        }

        public String getModel() {
            return Model;
        }

        public void setModel(String model) {
            this.Model = model;
        }


}
