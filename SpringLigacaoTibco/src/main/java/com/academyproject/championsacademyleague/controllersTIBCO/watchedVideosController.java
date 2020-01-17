package com.academyproject.championsacademyleague.controllersTIBCO;

import com.academyproject.championsacademyleague.schemas.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("watchedVideos")
public class watchedVideosController {

    @Autowired
    public com.academyproject.championsacademyleague.services.watchedVideosService watchedVideosService;

    /**
     * Connection with angular and the exterior
     * @return
     */

    @RequestMapping("getAll")
    public List<WatchedVideosOut> getAllWatchedVideos() {
        WatchedVideosDataInput dataIn= new WatchedVideosDataInput();
        WatchedVideosIn watchedVideosIn= new WatchedVideosIn("","");
        dataIn.getWatchedVideosIn().add(watchedVideosIn);
        return watchedVideosService.getAll(dataIn);

    }

    @RequestMapping("Create")
    public List<WatchedVideosOut> getCreateWatchedVideos(String idVideoFK, String idPlayerFK) {
        WatchedVideosDataInput dataIn= new WatchedVideosDataInput();
        WatchedVideosIn watchedVideosIn= new WatchedVideosIn(idVideoFK,idPlayerFK);
        dataIn.getWatchedVideosIn().add(watchedVideosIn);
        return watchedVideosService.create(dataIn);

    }

    @RequestMapping("Get")
    public List<WatchedVideosOut> getGetWatchedVideos(String idVideoFK, String idPlayerFK) {
        WatchedVideosDataInput dataIn= new WatchedVideosDataInput();
        WatchedVideosIn watchedVideosIn= new WatchedVideosIn(idVideoFK,idPlayerFK);
        dataIn.getWatchedVideosIn().add(watchedVideosIn);
        return watchedVideosService.get(dataIn);

    }

    @RequestMapping("Delete")
    public List<WatchedVideosOut> getDeleteWatchedVideos(String idVideoFK, String idPlayerFK) {
        WatchedVideosDataInput dataIn= new WatchedVideosDataInput();
        WatchedVideosIn watchedVideosIn= new WatchedVideosIn(idVideoFK,idPlayerFK);
        dataIn.getWatchedVideosIn().add(watchedVideosIn);
        return watchedVideosService.delete(dataIn);

    }

    /**
     * <p>Java class for anonymous complex type.
     *
     * <p>The following schema fragment specifies the expected content contained within this class.
     *
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;sequence&gt;
     *         &lt;element ref="{http://www.tibco.com/schemas/TheChampionsAcademyLeague/Service/Notifications/Schema.xsd}NotificationsIn" maxOccurs="unbounded" minOccurs="0"/&gt;
     *       &lt;/sequence&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     *
     *
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "notificationsIn"
    })
    @XmlRootElement(name = "NotificationsDataInput", namespace = "http://www.tibco.com/schemas/TheChampionsAcademyLeague/Service/Notifications/Schema.xsd")
    public static class NotificationsDataInput {

        @XmlElement(name = "NotificationsIn", namespace = "http://www.tibco.com/schemas/TheChampionsAcademyLeague/Service/Notifications/Schema.xsd")
        protected List<NotificationsIn> notificationsIn;

        /**
         * Gets the value of the notificationsIn property.
         *
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the notificationsIn property.
         *
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getNotificationsIn().add(newItem);
         * </pre>
         *
         *
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link NotificationsIn }
         *
         *
         */
        public List<NotificationsIn> getNotificationsIn() {
            if (notificationsIn == null) {
                notificationsIn = new ArrayList<NotificationsIn>();
            }
            return this.notificationsIn;
        }

    }
}
