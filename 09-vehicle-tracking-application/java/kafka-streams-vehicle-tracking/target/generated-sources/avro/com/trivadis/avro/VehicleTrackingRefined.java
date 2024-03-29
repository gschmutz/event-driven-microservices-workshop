/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package com.trivadis.avro;

import org.apache.avro.generic.GenericArray;
import org.apache.avro.specific.SpecificData;
import org.apache.avro.util.Utf8;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.SchemaStore;

@org.apache.avro.specific.AvroGenerated
public class VehicleTrackingRefined extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = 878786375912283927L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"VehicleTrackingRefined\",\"namespace\":\"com.trivadis.avro\",\"fields\":[{\"name\":\"SOURCE\",\"type\":[\"null\",\"string\"],\"default\":null},{\"name\":\"TIMESTAMP\",\"type\":[\"null\",\"string\"],\"default\":null},{\"name\":\"VEHICLEID\",\"type\":[\"null\",\"string\"],\"default\":null},{\"name\":\"DRIVERID\",\"type\":[\"null\",\"long\"],\"default\":null},{\"name\":\"ROUTEID\",\"type\":[\"null\",\"long\"],\"default\":null},{\"name\":\"EVENTTYPE\",\"type\":[\"null\",\"string\"],\"default\":null},{\"name\":\"LATITUDE\",\"type\":[\"null\",\"double\"],\"default\":null},{\"name\":\"LONGITUDE\",\"type\":[\"null\",\"double\"],\"default\":null},{\"name\":\"CORRELATIONID\",\"type\":[\"null\",\"string\"],\"default\":null}],\"connect.name\":\"com.trivadis.avro.VehicleTrackingRefined\"}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<VehicleTrackingRefined> ENCODER =
      new BinaryMessageEncoder<VehicleTrackingRefined>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<VehicleTrackingRefined> DECODER =
      new BinaryMessageDecoder<VehicleTrackingRefined>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageEncoder instance used by this class.
   * @return the message encoder used by this class
   */
  public static BinaryMessageEncoder<VehicleTrackingRefined> getEncoder() {
    return ENCODER;
  }

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   * @return the message decoder used by this class
   */
  public static BinaryMessageDecoder<VehicleTrackingRefined> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   * @return a BinaryMessageDecoder instance for this class backed by the given SchemaStore
   */
  public static BinaryMessageDecoder<VehicleTrackingRefined> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<VehicleTrackingRefined>(MODEL$, SCHEMA$, resolver);
  }

  /**
   * Serializes this VehicleTrackingRefined to a ByteBuffer.
   * @return a buffer holding the serialized data for this instance
   * @throws java.io.IOException if this instance could not be serialized
   */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /**
   * Deserializes a VehicleTrackingRefined from a ByteBuffer.
   * @param b a byte buffer holding serialized data for an instance of this class
   * @return a VehicleTrackingRefined instance decoded from the given buffer
   * @throws java.io.IOException if the given bytes could not be deserialized into an instance of this class
   */
  public static VehicleTrackingRefined fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

   private java.lang.CharSequence SOURCE;
   private java.lang.CharSequence TIMESTAMP;
   private java.lang.CharSequence VEHICLEID;
   private java.lang.Long DRIVERID;
   private java.lang.Long ROUTEID;
   private java.lang.CharSequence EVENTTYPE;
   private java.lang.Double LATITUDE;
   private java.lang.Double LONGITUDE;
   private java.lang.CharSequence CORRELATIONID;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public VehicleTrackingRefined() {}

  /**
   * All-args constructor.
   * @param SOURCE The new value for SOURCE
   * @param TIMESTAMP The new value for TIMESTAMP
   * @param VEHICLEID The new value for VEHICLEID
   * @param DRIVERID The new value for DRIVERID
   * @param ROUTEID The new value for ROUTEID
   * @param EVENTTYPE The new value for EVENTTYPE
   * @param LATITUDE The new value for LATITUDE
   * @param LONGITUDE The new value for LONGITUDE
   * @param CORRELATIONID The new value for CORRELATIONID
   */
  public VehicleTrackingRefined(java.lang.CharSequence SOURCE, java.lang.CharSequence TIMESTAMP, java.lang.CharSequence VEHICLEID, java.lang.Long DRIVERID, java.lang.Long ROUTEID, java.lang.CharSequence EVENTTYPE, java.lang.Double LATITUDE, java.lang.Double LONGITUDE, java.lang.CharSequence CORRELATIONID) {
    this.SOURCE = SOURCE;
    this.TIMESTAMP = TIMESTAMP;
    this.VEHICLEID = VEHICLEID;
    this.DRIVERID = DRIVERID;
    this.ROUTEID = ROUTEID;
    this.EVENTTYPE = EVENTTYPE;
    this.LATITUDE = LATITUDE;
    this.LONGITUDE = LONGITUDE;
    this.CORRELATIONID = CORRELATIONID;
  }

  public org.apache.avro.specific.SpecificData getSpecificData() { return MODEL$; }
  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return SOURCE;
    case 1: return TIMESTAMP;
    case 2: return VEHICLEID;
    case 3: return DRIVERID;
    case 4: return ROUTEID;
    case 5: return EVENTTYPE;
    case 6: return LATITUDE;
    case 7: return LONGITUDE;
    case 8: return CORRELATIONID;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: SOURCE = (java.lang.CharSequence)value$; break;
    case 1: TIMESTAMP = (java.lang.CharSequence)value$; break;
    case 2: VEHICLEID = (java.lang.CharSequence)value$; break;
    case 3: DRIVERID = (java.lang.Long)value$; break;
    case 4: ROUTEID = (java.lang.Long)value$; break;
    case 5: EVENTTYPE = (java.lang.CharSequence)value$; break;
    case 6: LATITUDE = (java.lang.Double)value$; break;
    case 7: LONGITUDE = (java.lang.Double)value$; break;
    case 8: CORRELATIONID = (java.lang.CharSequence)value$; break;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  /**
   * Gets the value of the 'SOURCE' field.
   * @return The value of the 'SOURCE' field.
   */
  public java.lang.CharSequence getSOURCE() {
    return SOURCE;
  }


  /**
   * Sets the value of the 'SOURCE' field.
   * @param value the value to set.
   */
  public void setSOURCE(java.lang.CharSequence value) {
    this.SOURCE = value;
  }

  /**
   * Gets the value of the 'TIMESTAMP' field.
   * @return The value of the 'TIMESTAMP' field.
   */
  public java.lang.CharSequence getTIMESTAMP() {
    return TIMESTAMP;
  }


  /**
   * Sets the value of the 'TIMESTAMP' field.
   * @param value the value to set.
   */
  public void setTIMESTAMP(java.lang.CharSequence value) {
    this.TIMESTAMP = value;
  }

  /**
   * Gets the value of the 'VEHICLEID' field.
   * @return The value of the 'VEHICLEID' field.
   */
  public java.lang.CharSequence getVEHICLEID() {
    return VEHICLEID;
  }


  /**
   * Sets the value of the 'VEHICLEID' field.
   * @param value the value to set.
   */
  public void setVEHICLEID(java.lang.CharSequence value) {
    this.VEHICLEID = value;
  }

  /**
   * Gets the value of the 'DRIVERID' field.
   * @return The value of the 'DRIVERID' field.
   */
  public java.lang.Long getDRIVERID() {
    return DRIVERID;
  }


  /**
   * Sets the value of the 'DRIVERID' field.
   * @param value the value to set.
   */
  public void setDRIVERID(java.lang.Long value) {
    this.DRIVERID = value;
  }

  /**
   * Gets the value of the 'ROUTEID' field.
   * @return The value of the 'ROUTEID' field.
   */
  public java.lang.Long getROUTEID() {
    return ROUTEID;
  }


  /**
   * Sets the value of the 'ROUTEID' field.
   * @param value the value to set.
   */
  public void setROUTEID(java.lang.Long value) {
    this.ROUTEID = value;
  }

  /**
   * Gets the value of the 'EVENTTYPE' field.
   * @return The value of the 'EVENTTYPE' field.
   */
  public java.lang.CharSequence getEVENTTYPE() {
    return EVENTTYPE;
  }


  /**
   * Sets the value of the 'EVENTTYPE' field.
   * @param value the value to set.
   */
  public void setEVENTTYPE(java.lang.CharSequence value) {
    this.EVENTTYPE = value;
  }

  /**
   * Gets the value of the 'LATITUDE' field.
   * @return The value of the 'LATITUDE' field.
   */
  public java.lang.Double getLATITUDE() {
    return LATITUDE;
  }


  /**
   * Sets the value of the 'LATITUDE' field.
   * @param value the value to set.
   */
  public void setLATITUDE(java.lang.Double value) {
    this.LATITUDE = value;
  }

  /**
   * Gets the value of the 'LONGITUDE' field.
   * @return The value of the 'LONGITUDE' field.
   */
  public java.lang.Double getLONGITUDE() {
    return LONGITUDE;
  }


  /**
   * Sets the value of the 'LONGITUDE' field.
   * @param value the value to set.
   */
  public void setLONGITUDE(java.lang.Double value) {
    this.LONGITUDE = value;
  }

  /**
   * Gets the value of the 'CORRELATIONID' field.
   * @return The value of the 'CORRELATIONID' field.
   */
  public java.lang.CharSequence getCORRELATIONID() {
    return CORRELATIONID;
  }


  /**
   * Sets the value of the 'CORRELATIONID' field.
   * @param value the value to set.
   */
  public void setCORRELATIONID(java.lang.CharSequence value) {
    this.CORRELATIONID = value;
  }

  /**
   * Creates a new VehicleTrackingRefined RecordBuilder.
   * @return A new VehicleTrackingRefined RecordBuilder
   */
  public static com.trivadis.avro.VehicleTrackingRefined.Builder newBuilder() {
    return new com.trivadis.avro.VehicleTrackingRefined.Builder();
  }

  /**
   * Creates a new VehicleTrackingRefined RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new VehicleTrackingRefined RecordBuilder
   */
  public static com.trivadis.avro.VehicleTrackingRefined.Builder newBuilder(com.trivadis.avro.VehicleTrackingRefined.Builder other) {
    if (other == null) {
      return new com.trivadis.avro.VehicleTrackingRefined.Builder();
    } else {
      return new com.trivadis.avro.VehicleTrackingRefined.Builder(other);
    }
  }

  /**
   * Creates a new VehicleTrackingRefined RecordBuilder by copying an existing VehicleTrackingRefined instance.
   * @param other The existing instance to copy.
   * @return A new VehicleTrackingRefined RecordBuilder
   */
  public static com.trivadis.avro.VehicleTrackingRefined.Builder newBuilder(com.trivadis.avro.VehicleTrackingRefined other) {
    if (other == null) {
      return new com.trivadis.avro.VehicleTrackingRefined.Builder();
    } else {
      return new com.trivadis.avro.VehicleTrackingRefined.Builder(other);
    }
  }

  /**
   * RecordBuilder for VehicleTrackingRefined instances.
   */
  @org.apache.avro.specific.AvroGenerated
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<VehicleTrackingRefined>
    implements org.apache.avro.data.RecordBuilder<VehicleTrackingRefined> {

    private java.lang.CharSequence SOURCE;
    private java.lang.CharSequence TIMESTAMP;
    private java.lang.CharSequence VEHICLEID;
    private java.lang.Long DRIVERID;
    private java.lang.Long ROUTEID;
    private java.lang.CharSequence EVENTTYPE;
    private java.lang.Double LATITUDE;
    private java.lang.Double LONGITUDE;
    private java.lang.CharSequence CORRELATIONID;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(com.trivadis.avro.VehicleTrackingRefined.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.SOURCE)) {
        this.SOURCE = data().deepCopy(fields()[0].schema(), other.SOURCE);
        fieldSetFlags()[0] = other.fieldSetFlags()[0];
      }
      if (isValidValue(fields()[1], other.TIMESTAMP)) {
        this.TIMESTAMP = data().deepCopy(fields()[1].schema(), other.TIMESTAMP);
        fieldSetFlags()[1] = other.fieldSetFlags()[1];
      }
      if (isValidValue(fields()[2], other.VEHICLEID)) {
        this.VEHICLEID = data().deepCopy(fields()[2].schema(), other.VEHICLEID);
        fieldSetFlags()[2] = other.fieldSetFlags()[2];
      }
      if (isValidValue(fields()[3], other.DRIVERID)) {
        this.DRIVERID = data().deepCopy(fields()[3].schema(), other.DRIVERID);
        fieldSetFlags()[3] = other.fieldSetFlags()[3];
      }
      if (isValidValue(fields()[4], other.ROUTEID)) {
        this.ROUTEID = data().deepCopy(fields()[4].schema(), other.ROUTEID);
        fieldSetFlags()[4] = other.fieldSetFlags()[4];
      }
      if (isValidValue(fields()[5], other.EVENTTYPE)) {
        this.EVENTTYPE = data().deepCopy(fields()[5].schema(), other.EVENTTYPE);
        fieldSetFlags()[5] = other.fieldSetFlags()[5];
      }
      if (isValidValue(fields()[6], other.LATITUDE)) {
        this.LATITUDE = data().deepCopy(fields()[6].schema(), other.LATITUDE);
        fieldSetFlags()[6] = other.fieldSetFlags()[6];
      }
      if (isValidValue(fields()[7], other.LONGITUDE)) {
        this.LONGITUDE = data().deepCopy(fields()[7].schema(), other.LONGITUDE);
        fieldSetFlags()[7] = other.fieldSetFlags()[7];
      }
      if (isValidValue(fields()[8], other.CORRELATIONID)) {
        this.CORRELATIONID = data().deepCopy(fields()[8].schema(), other.CORRELATIONID);
        fieldSetFlags()[8] = other.fieldSetFlags()[8];
      }
    }

    /**
     * Creates a Builder by copying an existing VehicleTrackingRefined instance
     * @param other The existing instance to copy.
     */
    private Builder(com.trivadis.avro.VehicleTrackingRefined other) {
      super(SCHEMA$);
      if (isValidValue(fields()[0], other.SOURCE)) {
        this.SOURCE = data().deepCopy(fields()[0].schema(), other.SOURCE);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.TIMESTAMP)) {
        this.TIMESTAMP = data().deepCopy(fields()[1].schema(), other.TIMESTAMP);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.VEHICLEID)) {
        this.VEHICLEID = data().deepCopy(fields()[2].schema(), other.VEHICLEID);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.DRIVERID)) {
        this.DRIVERID = data().deepCopy(fields()[3].schema(), other.DRIVERID);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.ROUTEID)) {
        this.ROUTEID = data().deepCopy(fields()[4].schema(), other.ROUTEID);
        fieldSetFlags()[4] = true;
      }
      if (isValidValue(fields()[5], other.EVENTTYPE)) {
        this.EVENTTYPE = data().deepCopy(fields()[5].schema(), other.EVENTTYPE);
        fieldSetFlags()[5] = true;
      }
      if (isValidValue(fields()[6], other.LATITUDE)) {
        this.LATITUDE = data().deepCopy(fields()[6].schema(), other.LATITUDE);
        fieldSetFlags()[6] = true;
      }
      if (isValidValue(fields()[7], other.LONGITUDE)) {
        this.LONGITUDE = data().deepCopy(fields()[7].schema(), other.LONGITUDE);
        fieldSetFlags()[7] = true;
      }
      if (isValidValue(fields()[8], other.CORRELATIONID)) {
        this.CORRELATIONID = data().deepCopy(fields()[8].schema(), other.CORRELATIONID);
        fieldSetFlags()[8] = true;
      }
    }

    /**
      * Gets the value of the 'SOURCE' field.
      * @return The value.
      */
    public java.lang.CharSequence getSOURCE() {
      return SOURCE;
    }


    /**
      * Sets the value of the 'SOURCE' field.
      * @param value The value of 'SOURCE'.
      * @return This builder.
      */
    public com.trivadis.avro.VehicleTrackingRefined.Builder setSOURCE(java.lang.CharSequence value) {
      validate(fields()[0], value);
      this.SOURCE = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'SOURCE' field has been set.
      * @return True if the 'SOURCE' field has been set, false otherwise.
      */
    public boolean hasSOURCE() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'SOURCE' field.
      * @return This builder.
      */
    public com.trivadis.avro.VehicleTrackingRefined.Builder clearSOURCE() {
      SOURCE = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'TIMESTAMP' field.
      * @return The value.
      */
    public java.lang.CharSequence getTIMESTAMP() {
      return TIMESTAMP;
    }


    /**
      * Sets the value of the 'TIMESTAMP' field.
      * @param value The value of 'TIMESTAMP'.
      * @return This builder.
      */
    public com.trivadis.avro.VehicleTrackingRefined.Builder setTIMESTAMP(java.lang.CharSequence value) {
      validate(fields()[1], value);
      this.TIMESTAMP = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'TIMESTAMP' field has been set.
      * @return True if the 'TIMESTAMP' field has been set, false otherwise.
      */
    public boolean hasTIMESTAMP() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'TIMESTAMP' field.
      * @return This builder.
      */
    public com.trivadis.avro.VehicleTrackingRefined.Builder clearTIMESTAMP() {
      TIMESTAMP = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'VEHICLEID' field.
      * @return The value.
      */
    public java.lang.CharSequence getVEHICLEID() {
      return VEHICLEID;
    }


    /**
      * Sets the value of the 'VEHICLEID' field.
      * @param value The value of 'VEHICLEID'.
      * @return This builder.
      */
    public com.trivadis.avro.VehicleTrackingRefined.Builder setVEHICLEID(java.lang.CharSequence value) {
      validate(fields()[2], value);
      this.VEHICLEID = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'VEHICLEID' field has been set.
      * @return True if the 'VEHICLEID' field has been set, false otherwise.
      */
    public boolean hasVEHICLEID() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'VEHICLEID' field.
      * @return This builder.
      */
    public com.trivadis.avro.VehicleTrackingRefined.Builder clearVEHICLEID() {
      VEHICLEID = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    /**
      * Gets the value of the 'DRIVERID' field.
      * @return The value.
      */
    public java.lang.Long getDRIVERID() {
      return DRIVERID;
    }


    /**
      * Sets the value of the 'DRIVERID' field.
      * @param value The value of 'DRIVERID'.
      * @return This builder.
      */
    public com.trivadis.avro.VehicleTrackingRefined.Builder setDRIVERID(java.lang.Long value) {
      validate(fields()[3], value);
      this.DRIVERID = value;
      fieldSetFlags()[3] = true;
      return this;
    }

    /**
      * Checks whether the 'DRIVERID' field has been set.
      * @return True if the 'DRIVERID' field has been set, false otherwise.
      */
    public boolean hasDRIVERID() {
      return fieldSetFlags()[3];
    }


    /**
      * Clears the value of the 'DRIVERID' field.
      * @return This builder.
      */
    public com.trivadis.avro.VehicleTrackingRefined.Builder clearDRIVERID() {
      DRIVERID = null;
      fieldSetFlags()[3] = false;
      return this;
    }

    /**
      * Gets the value of the 'ROUTEID' field.
      * @return The value.
      */
    public java.lang.Long getROUTEID() {
      return ROUTEID;
    }


    /**
      * Sets the value of the 'ROUTEID' field.
      * @param value The value of 'ROUTEID'.
      * @return This builder.
      */
    public com.trivadis.avro.VehicleTrackingRefined.Builder setROUTEID(java.lang.Long value) {
      validate(fields()[4], value);
      this.ROUTEID = value;
      fieldSetFlags()[4] = true;
      return this;
    }

    /**
      * Checks whether the 'ROUTEID' field has been set.
      * @return True if the 'ROUTEID' field has been set, false otherwise.
      */
    public boolean hasROUTEID() {
      return fieldSetFlags()[4];
    }


    /**
      * Clears the value of the 'ROUTEID' field.
      * @return This builder.
      */
    public com.trivadis.avro.VehicleTrackingRefined.Builder clearROUTEID() {
      ROUTEID = null;
      fieldSetFlags()[4] = false;
      return this;
    }

    /**
      * Gets the value of the 'EVENTTYPE' field.
      * @return The value.
      */
    public java.lang.CharSequence getEVENTTYPE() {
      return EVENTTYPE;
    }


    /**
      * Sets the value of the 'EVENTTYPE' field.
      * @param value The value of 'EVENTTYPE'.
      * @return This builder.
      */
    public com.trivadis.avro.VehicleTrackingRefined.Builder setEVENTTYPE(java.lang.CharSequence value) {
      validate(fields()[5], value);
      this.EVENTTYPE = value;
      fieldSetFlags()[5] = true;
      return this;
    }

    /**
      * Checks whether the 'EVENTTYPE' field has been set.
      * @return True if the 'EVENTTYPE' field has been set, false otherwise.
      */
    public boolean hasEVENTTYPE() {
      return fieldSetFlags()[5];
    }


    /**
      * Clears the value of the 'EVENTTYPE' field.
      * @return This builder.
      */
    public com.trivadis.avro.VehicleTrackingRefined.Builder clearEVENTTYPE() {
      EVENTTYPE = null;
      fieldSetFlags()[5] = false;
      return this;
    }

    /**
      * Gets the value of the 'LATITUDE' field.
      * @return The value.
      */
    public java.lang.Double getLATITUDE() {
      return LATITUDE;
    }


    /**
      * Sets the value of the 'LATITUDE' field.
      * @param value The value of 'LATITUDE'.
      * @return This builder.
      */
    public com.trivadis.avro.VehicleTrackingRefined.Builder setLATITUDE(java.lang.Double value) {
      validate(fields()[6], value);
      this.LATITUDE = value;
      fieldSetFlags()[6] = true;
      return this;
    }

    /**
      * Checks whether the 'LATITUDE' field has been set.
      * @return True if the 'LATITUDE' field has been set, false otherwise.
      */
    public boolean hasLATITUDE() {
      return fieldSetFlags()[6];
    }


    /**
      * Clears the value of the 'LATITUDE' field.
      * @return This builder.
      */
    public com.trivadis.avro.VehicleTrackingRefined.Builder clearLATITUDE() {
      LATITUDE = null;
      fieldSetFlags()[6] = false;
      return this;
    }

    /**
      * Gets the value of the 'LONGITUDE' field.
      * @return The value.
      */
    public java.lang.Double getLONGITUDE() {
      return LONGITUDE;
    }


    /**
      * Sets the value of the 'LONGITUDE' field.
      * @param value The value of 'LONGITUDE'.
      * @return This builder.
      */
    public com.trivadis.avro.VehicleTrackingRefined.Builder setLONGITUDE(java.lang.Double value) {
      validate(fields()[7], value);
      this.LONGITUDE = value;
      fieldSetFlags()[7] = true;
      return this;
    }

    /**
      * Checks whether the 'LONGITUDE' field has been set.
      * @return True if the 'LONGITUDE' field has been set, false otherwise.
      */
    public boolean hasLONGITUDE() {
      return fieldSetFlags()[7];
    }


    /**
      * Clears the value of the 'LONGITUDE' field.
      * @return This builder.
      */
    public com.trivadis.avro.VehicleTrackingRefined.Builder clearLONGITUDE() {
      LONGITUDE = null;
      fieldSetFlags()[7] = false;
      return this;
    }

    /**
      * Gets the value of the 'CORRELATIONID' field.
      * @return The value.
      */
    public java.lang.CharSequence getCORRELATIONID() {
      return CORRELATIONID;
    }


    /**
      * Sets the value of the 'CORRELATIONID' field.
      * @param value The value of 'CORRELATIONID'.
      * @return This builder.
      */
    public com.trivadis.avro.VehicleTrackingRefined.Builder setCORRELATIONID(java.lang.CharSequence value) {
      validate(fields()[8], value);
      this.CORRELATIONID = value;
      fieldSetFlags()[8] = true;
      return this;
    }

    /**
      * Checks whether the 'CORRELATIONID' field has been set.
      * @return True if the 'CORRELATIONID' field has been set, false otherwise.
      */
    public boolean hasCORRELATIONID() {
      return fieldSetFlags()[8];
    }


    /**
      * Clears the value of the 'CORRELATIONID' field.
      * @return This builder.
      */
    public com.trivadis.avro.VehicleTrackingRefined.Builder clearCORRELATIONID() {
      CORRELATIONID = null;
      fieldSetFlags()[8] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public VehicleTrackingRefined build() {
      try {
        VehicleTrackingRefined record = new VehicleTrackingRefined();
        record.SOURCE = fieldSetFlags()[0] ? this.SOURCE : (java.lang.CharSequence) defaultValue(fields()[0]);
        record.TIMESTAMP = fieldSetFlags()[1] ? this.TIMESTAMP : (java.lang.CharSequence) defaultValue(fields()[1]);
        record.VEHICLEID = fieldSetFlags()[2] ? this.VEHICLEID : (java.lang.CharSequence) defaultValue(fields()[2]);
        record.DRIVERID = fieldSetFlags()[3] ? this.DRIVERID : (java.lang.Long) defaultValue(fields()[3]);
        record.ROUTEID = fieldSetFlags()[4] ? this.ROUTEID : (java.lang.Long) defaultValue(fields()[4]);
        record.EVENTTYPE = fieldSetFlags()[5] ? this.EVENTTYPE : (java.lang.CharSequence) defaultValue(fields()[5]);
        record.LATITUDE = fieldSetFlags()[6] ? this.LATITUDE : (java.lang.Double) defaultValue(fields()[6]);
        record.LONGITUDE = fieldSetFlags()[7] ? this.LONGITUDE : (java.lang.Double) defaultValue(fields()[7]);
        record.CORRELATIONID = fieldSetFlags()[8] ? this.CORRELATIONID : (java.lang.CharSequence) defaultValue(fields()[8]);
        return record;
      } catch (org.apache.avro.AvroMissingFieldException e) {
        throw e;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<VehicleTrackingRefined>
    WRITER$ = (org.apache.avro.io.DatumWriter<VehicleTrackingRefined>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<VehicleTrackingRefined>
    READER$ = (org.apache.avro.io.DatumReader<VehicleTrackingRefined>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

  @Override protected boolean hasCustomCoders() { return true; }

  @Override public void customEncode(org.apache.avro.io.Encoder out)
    throws java.io.IOException
  {
    if (this.SOURCE == null) {
      out.writeIndex(0);
      out.writeNull();
    } else {
      out.writeIndex(1);
      out.writeString(this.SOURCE);
    }

    if (this.TIMESTAMP == null) {
      out.writeIndex(0);
      out.writeNull();
    } else {
      out.writeIndex(1);
      out.writeString(this.TIMESTAMP);
    }

    if (this.VEHICLEID == null) {
      out.writeIndex(0);
      out.writeNull();
    } else {
      out.writeIndex(1);
      out.writeString(this.VEHICLEID);
    }

    if (this.DRIVERID == null) {
      out.writeIndex(0);
      out.writeNull();
    } else {
      out.writeIndex(1);
      out.writeLong(this.DRIVERID);
    }

    if (this.ROUTEID == null) {
      out.writeIndex(0);
      out.writeNull();
    } else {
      out.writeIndex(1);
      out.writeLong(this.ROUTEID);
    }

    if (this.EVENTTYPE == null) {
      out.writeIndex(0);
      out.writeNull();
    } else {
      out.writeIndex(1);
      out.writeString(this.EVENTTYPE);
    }

    if (this.LATITUDE == null) {
      out.writeIndex(0);
      out.writeNull();
    } else {
      out.writeIndex(1);
      out.writeDouble(this.LATITUDE);
    }

    if (this.LONGITUDE == null) {
      out.writeIndex(0);
      out.writeNull();
    } else {
      out.writeIndex(1);
      out.writeDouble(this.LONGITUDE);
    }

    if (this.CORRELATIONID == null) {
      out.writeIndex(0);
      out.writeNull();
    } else {
      out.writeIndex(1);
      out.writeString(this.CORRELATIONID);
    }

  }

  @Override public void customDecode(org.apache.avro.io.ResolvingDecoder in)
    throws java.io.IOException
  {
    org.apache.avro.Schema.Field[] fieldOrder = in.readFieldOrderIfDiff();
    if (fieldOrder == null) {
      if (in.readIndex() != 1) {
        in.readNull();
        this.SOURCE = null;
      } else {
        this.SOURCE = in.readString(this.SOURCE instanceof Utf8 ? (Utf8)this.SOURCE : null);
      }

      if (in.readIndex() != 1) {
        in.readNull();
        this.TIMESTAMP = null;
      } else {
        this.TIMESTAMP = in.readString(this.TIMESTAMP instanceof Utf8 ? (Utf8)this.TIMESTAMP : null);
      }

      if (in.readIndex() != 1) {
        in.readNull();
        this.VEHICLEID = null;
      } else {
        this.VEHICLEID = in.readString(this.VEHICLEID instanceof Utf8 ? (Utf8)this.VEHICLEID : null);
      }

      if (in.readIndex() != 1) {
        in.readNull();
        this.DRIVERID = null;
      } else {
        this.DRIVERID = in.readLong();
      }

      if (in.readIndex() != 1) {
        in.readNull();
        this.ROUTEID = null;
      } else {
        this.ROUTEID = in.readLong();
      }

      if (in.readIndex() != 1) {
        in.readNull();
        this.EVENTTYPE = null;
      } else {
        this.EVENTTYPE = in.readString(this.EVENTTYPE instanceof Utf8 ? (Utf8)this.EVENTTYPE : null);
      }

      if (in.readIndex() != 1) {
        in.readNull();
        this.LATITUDE = null;
      } else {
        this.LATITUDE = in.readDouble();
      }

      if (in.readIndex() != 1) {
        in.readNull();
        this.LONGITUDE = null;
      } else {
        this.LONGITUDE = in.readDouble();
      }

      if (in.readIndex() != 1) {
        in.readNull();
        this.CORRELATIONID = null;
      } else {
        this.CORRELATIONID = in.readString(this.CORRELATIONID instanceof Utf8 ? (Utf8)this.CORRELATIONID : null);
      }

    } else {
      for (int i = 0; i < 9; i++) {
        switch (fieldOrder[i].pos()) {
        case 0:
          if (in.readIndex() != 1) {
            in.readNull();
            this.SOURCE = null;
          } else {
            this.SOURCE = in.readString(this.SOURCE instanceof Utf8 ? (Utf8)this.SOURCE : null);
          }
          break;

        case 1:
          if (in.readIndex() != 1) {
            in.readNull();
            this.TIMESTAMP = null;
          } else {
            this.TIMESTAMP = in.readString(this.TIMESTAMP instanceof Utf8 ? (Utf8)this.TIMESTAMP : null);
          }
          break;

        case 2:
          if (in.readIndex() != 1) {
            in.readNull();
            this.VEHICLEID = null;
          } else {
            this.VEHICLEID = in.readString(this.VEHICLEID instanceof Utf8 ? (Utf8)this.VEHICLEID : null);
          }
          break;

        case 3:
          if (in.readIndex() != 1) {
            in.readNull();
            this.DRIVERID = null;
          } else {
            this.DRIVERID = in.readLong();
          }
          break;

        case 4:
          if (in.readIndex() != 1) {
            in.readNull();
            this.ROUTEID = null;
          } else {
            this.ROUTEID = in.readLong();
          }
          break;

        case 5:
          if (in.readIndex() != 1) {
            in.readNull();
            this.EVENTTYPE = null;
          } else {
            this.EVENTTYPE = in.readString(this.EVENTTYPE instanceof Utf8 ? (Utf8)this.EVENTTYPE : null);
          }
          break;

        case 6:
          if (in.readIndex() != 1) {
            in.readNull();
            this.LATITUDE = null;
          } else {
            this.LATITUDE = in.readDouble();
          }
          break;

        case 7:
          if (in.readIndex() != 1) {
            in.readNull();
            this.LONGITUDE = null;
          } else {
            this.LONGITUDE = in.readDouble();
          }
          break;

        case 8:
          if (in.readIndex() != 1) {
            in.readNull();
            this.CORRELATIONID = null;
          } else {
            this.CORRELATIONID = in.readString(this.CORRELATIONID instanceof Utf8 ? (Utf8)this.CORRELATIONID : null);
          }
          break;

        default:
          throw new java.io.IOException("Corrupt ResolvingDecoder.");
        }
      }
    }
  }
}










