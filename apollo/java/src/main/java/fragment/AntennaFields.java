package fragment;

import com.apollographql.apollo.api.GraphqlFragment;
import com.apollographql.apollo.api.ResponseField;
import com.apollographql.apollo.api.ResponseFieldMapper;
import com.apollographql.apollo.api.ResponseFieldMarshaller;
import com.apollographql.apollo.api.ResponseReader;
import com.apollographql.apollo.api.ResponseWriter;
import java.lang.Double;
import java.lang.Integer;
import java.lang.NullPointerException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

@Generated("Apollo GraphQL")
public class AntennaFields implements GraphqlFragment {
  static final ResponseField[] $responseFields = {
    ResponseField.forString("__typename", "__typename", null, false),
    ResponseField.forObject("coordinates", "coordinates", null, true),
    ResponseField.forString("generation", "generation", null, true),
    ResponseField.forString("provider", "provider", null, true),
    ResponseField.forString("lastUpdate", "lastUpdate", null, true),
    ResponseField.forString("status", "status", null, true),
    ResponseField.forInt("dist", "dist", null, true),
    ResponseField.forString("insee", "insee", null, true),
    ResponseField.forString("city", "city", null, true),
    ResponseField.forString("addressLabel", "addressLabel", null, true)
  };

  public static final String FRAGMENT_DEFINITION = "fragment antennaFields on NearestAntenna {\n"
      + "  __typename\n"
      + "  coordinates {\n"
      + "    latitude\n"
      + "    longitude\n"
      + "  }\n"
      + "  generation\n"
      + "  provider\n"
      + "  lastUpdate\n"
      + "  status\n"
      + "  dist\n"
      + "  insee\n"
      + "  city\n"
      + "  addressLabel\n"
      + "}";

  public static final List<String> POSSIBLE_TYPES = Collections.unmodifiableList(Arrays.asList( "NearestAntenna"));

  final @Nonnull String __typename;

  final @Nullable Coordinates coordinates;

  final @Nullable String generation;

  final @Nullable String provider;

  final @Nullable String lastUpdate;

  final @Nullable String status;

  final @Nullable Integer dist;

  final @Nullable String insee;

  final @Nullable String city;

  final @Nullable String addressLabel;

  private volatile String $toString;

  private volatile int $hashCode;

  private volatile boolean $hashCodeMemoized;

  public AntennaFields(@Nonnull String __typename, @Nullable Coordinates coordinates,
      @Nullable String generation, @Nullable String provider, @Nullable String lastUpdate,
      @Nullable String status, @Nullable Integer dist, @Nullable String insee,
      @Nullable String city, @Nullable String addressLabel) {
    if (__typename == null) {
      throw new NullPointerException("__typename can't be null");
    }
    this.__typename = __typename;
    this.coordinates = coordinates;
    this.generation = generation;
    this.provider = provider;
    this.lastUpdate = lastUpdate;
    this.status = status;
    this.dist = dist;
    this.insee = insee;
    this.city = city;
    this.addressLabel = addressLabel;
  }

  public @Nonnull String __typename() {
    return this.__typename;
  }

  public @Nullable Coordinates coordinates() {
    return this.coordinates;
  }

  public @Nullable String generation() {
    return this.generation;
  }

  public @Nullable String provider() {
    return this.provider;
  }

  public @Nullable String lastUpdate() {
    return this.lastUpdate;
  }

  public @Nullable String status() {
    return this.status;
  }

  public @Nullable Integer dist() {
    return this.dist;
  }

  public @Nullable String insee() {
    return this.insee;
  }

  public @Nullable String city() {
    return this.city;
  }

  public @Nullable String addressLabel() {
    return this.addressLabel;
  }

  public ResponseFieldMarshaller marshaller() {
    return new ResponseFieldMarshaller() {
      @Override
      public void marshal(ResponseWriter writer) {
        writer.writeString($responseFields[0], __typename);
        writer.writeObject($responseFields[1], coordinates != null ? coordinates.marshaller() : null);
        writer.writeString($responseFields[2], generation);
        writer.writeString($responseFields[3], provider);
        writer.writeString($responseFields[4], lastUpdate);
        writer.writeString($responseFields[5], status);
        writer.writeInt($responseFields[6], dist);
        writer.writeString($responseFields[7], insee);
        writer.writeString($responseFields[8], city);
        writer.writeString($responseFields[9], addressLabel);
      }
    };
  }

  @Override
  public String toString() {
    if ($toString == null) {
      $toString = "AntennaFields{"
        + "__typename=" + __typename + ", "
        + "coordinates=" + coordinates + ", "
        + "generation=" + generation + ", "
        + "provider=" + provider + ", "
        + "lastUpdate=" + lastUpdate + ", "
        + "status=" + status + ", "
        + "dist=" + dist + ", "
        + "insee=" + insee + ", "
        + "city=" + city + ", "
        + "addressLabel=" + addressLabel
        + "}";
    }
    return $toString;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof AntennaFields) {
      AntennaFields that = (AntennaFields) o;
      return this.__typename.equals(that.__typename)
       && ((this.coordinates == null) ? (that.coordinates == null) : this.coordinates.equals(that.coordinates))
       && ((this.generation == null) ? (that.generation == null) : this.generation.equals(that.generation))
       && ((this.provider == null) ? (that.provider == null) : this.provider.equals(that.provider))
       && ((this.lastUpdate == null) ? (that.lastUpdate == null) : this.lastUpdate.equals(that.lastUpdate))
       && ((this.status == null) ? (that.status == null) : this.status.equals(that.status))
       && ((this.dist == null) ? (that.dist == null) : this.dist.equals(that.dist))
       && ((this.insee == null) ? (that.insee == null) : this.insee.equals(that.insee))
       && ((this.city == null) ? (that.city == null) : this.city.equals(that.city))
       && ((this.addressLabel == null) ? (that.addressLabel == null) : this.addressLabel.equals(that.addressLabel));
    }
    return false;
  }

  @Override
  public int hashCode() {
    if (!$hashCodeMemoized) {
      int h = 1;
      h *= 1000003;
      h ^= __typename.hashCode();
      h *= 1000003;
      h ^= (coordinates == null) ? 0 : coordinates.hashCode();
      h *= 1000003;
      h ^= (generation == null) ? 0 : generation.hashCode();
      h *= 1000003;
      h ^= (provider == null) ? 0 : provider.hashCode();
      h *= 1000003;
      h ^= (lastUpdate == null) ? 0 : lastUpdate.hashCode();
      h *= 1000003;
      h ^= (status == null) ? 0 : status.hashCode();
      h *= 1000003;
      h ^= (dist == null) ? 0 : dist.hashCode();
      h *= 1000003;
      h ^= (insee == null) ? 0 : insee.hashCode();
      h *= 1000003;
      h ^= (city == null) ? 0 : city.hashCode();
      h *= 1000003;
      h ^= (addressLabel == null) ? 0 : addressLabel.hashCode();
      $hashCode = h;
      $hashCodeMemoized = true;
    }
    return $hashCode;
  }

  public static final class Mapper implements ResponseFieldMapper<AntennaFields> {
    final Coordinates.Mapper coordinatesFieldMapper = new Coordinates.Mapper();

    @Override
    public AntennaFields map(ResponseReader reader) {
      final String __typename = reader.readString($responseFields[0]);
      final Coordinates coordinates = reader.readObject($responseFields[1], new ResponseReader.ObjectReader<Coordinates>() {
        @Override
        public Coordinates read(ResponseReader reader) {
          return coordinatesFieldMapper.map(reader);
        }
      });
      final String generation = reader.readString($responseFields[2]);
      final String provider = reader.readString($responseFields[3]);
      final String lastUpdate = reader.readString($responseFields[4]);
      final String status = reader.readString($responseFields[5]);
      final Integer dist = reader.readInt($responseFields[6]);
      final String insee = reader.readString($responseFields[7]);
      final String city = reader.readString($responseFields[8]);
      final String addressLabel = reader.readString($responseFields[9]);
      return new AntennaFields(__typename, coordinates, generation, provider, lastUpdate, status, dist, insee, city, addressLabel);
    }
  }

  public static class Coordinates {
    static final ResponseField[] $responseFields = {
      ResponseField.forDouble("latitude", "latitude", null, true),
      ResponseField.forDouble("longitude", "longitude", null, true)
    };

    final @Nullable Double latitude;

    final @Nullable Double longitude;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public Coordinates(@Nullable Double latitude, @Nullable Double longitude) {
      this.latitude = latitude;
      this.longitude = longitude;
    }

    public @Nullable Double latitude() {
      return this.latitude;
    }

    public @Nullable Double longitude() {
      return this.longitude;
    }

    public ResponseFieldMarshaller marshaller() {
      return new ResponseFieldMarshaller() {
        @Override
        public void marshal(ResponseWriter writer) {
          writer.writeDouble($responseFields[0], latitude);
          writer.writeDouble($responseFields[1], longitude);
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "Coordinates{"
          + "latitude=" + latitude + ", "
          + "longitude=" + longitude
          + "}";
      }
      return $toString;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (o instanceof Coordinates) {
        Coordinates that = (Coordinates) o;
        return ((this.latitude == null) ? (that.latitude == null) : this.latitude.equals(that.latitude))
         && ((this.longitude == null) ? (that.longitude == null) : this.longitude.equals(that.longitude));
      }
      return false;
    }

    @Override
    public int hashCode() {
      if (!$hashCodeMemoized) {
        int h = 1;
        h *= 1000003;
        h ^= (latitude == null) ? 0 : latitude.hashCode();
        h *= 1000003;
        h ^= (longitude == null) ? 0 : longitude.hashCode();
        $hashCode = h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    public static final class Mapper implements ResponseFieldMapper<Coordinates> {
      @Override
      public Coordinates map(ResponseReader reader) {
        final Double latitude = reader.readDouble($responseFields[0]);
        final Double longitude = reader.readDouble($responseFields[1]);
        return new Coordinates(latitude, longitude);
      }
    }
  }
}
