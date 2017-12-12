import com.apollographql.apollo.api.FragmentResponseFieldMapper;
import com.apollographql.apollo.api.InputFieldMarshaller;
import com.apollographql.apollo.api.InputFieldWriter;
import com.apollographql.apollo.api.Operation;
import com.apollographql.apollo.api.OperationName;
import com.apollographql.apollo.api.Query;
import com.apollographql.apollo.api.ResponseField;
import com.apollographql.apollo.api.ResponseFieldMapper;
import com.apollographql.apollo.api.ResponseFieldMarshaller;
import com.apollographql.apollo.api.ResponseReader;
import com.apollographql.apollo.api.ResponseWriter;
import com.apollographql.apollo.api.internal.UnmodifiableMapBuilder;
import com.apollographql.apollo.api.internal.Utils;
import fragment.AntennaFields;
import java.io.IOException;
import java.lang.Double;
import java.lang.IllegalStateException;
import java.lang.Integer;
import java.lang.NullPointerException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

@Generated("Apollo GraphQL")
public final class SearchQuery implements Query<SearchQuery.Data, SearchQuery.Data, SearchQuery.Variables> {
  public static final String OPERATION_DEFINITION = "query search($query: String!) {\n"
      + "  search(query: $query) {\n"
      + "    __typename\n"
      + "    ... on Street {\n"
      + "      street\n"
      + "      city\n"
      + "      zipCode\n"
      + "    }\n"
      + "    ... on City {\n"
      + "      city\n"
      + "      zipCode\n"
      + "    }\n"
      + "    ... on HouseNumber {\n"
      + "      houseNumber\n"
      + "      street\n"
      + "      city\n"
      + "      zipCode\n"
      + "    }\n"
      + "    nearestAntennaFromOrange: nearestAntenna(provider: ORANGE) {\n"
      + "      ...antennaFields\n"
      + "    }\n"
      + "    nearestAntennaFromBouygues: nearestAntenna(provider: BOUYGUES_TELECOM) {\n"
      + "      ...antennaFields\n"
      + "    }\n"
      + "    nearestAntennaFromSfr: nearestAntenna(provider: SFR) {\n"
      + "      ...antennaFields\n"
      + "    }\n"
      + "    nearestAntennaFromFree: nearestAntenna(provider: FREE) {\n"
      + "      ...antennaFields\n"
      + "    }\n"
      + "  }\n"
      + "}";

  public static final String QUERY_DOCUMENT = OPERATION_DEFINITION + "\n"
   + AntennaFields.FRAGMENT_DEFINITION;

  private static final OperationName OPERATION_NAME = new OperationName() {
    @Override
    public String name() {
      return "search";
    }
  };

  private final SearchQuery.Variables variables;

  public SearchQuery(@Nonnull String query) {
    Utils.checkNotNull(query, "query == null");
    variables = new SearchQuery.Variables(query);
  }

  @Override
  public String operationId() {
    return "38fd56bde42926e432fc6584ef569c21b3c8d76090f0ca00acd42415fb8c5d4a";
  }

  @Override
  public String queryDocument() {
    return QUERY_DOCUMENT;
  }

  @Override
  public SearchQuery.Data wrapData(SearchQuery.Data data) {
    return data;
  }

  @Override
  public SearchQuery.Variables variables() {
    return variables;
  }

  @Override
  public ResponseFieldMapper<SearchQuery.Data> responseFieldMapper() {
    return new Data.Mapper();
  }

  public static Builder builder() {
    return new Builder();
  }

  @Override
  public OperationName name() {
    return OPERATION_NAME;
  }

  public static final class Variables extends Operation.Variables {
    private final @Nonnull String query;

    private final transient Map<String, Object> valueMap = new LinkedHashMap<>();

    Variables(@Nonnull String query) {
      this.query = query;
      this.valueMap.put("query", query);
    }

    public @Nonnull String query() {
      return query;
    }

    @Override
    public Map<String, Object> valueMap() {
      return Collections.unmodifiableMap(valueMap);
    }

    @Override
    public InputFieldMarshaller marshaller() {
      return new InputFieldMarshaller() {
        @Override
        public void marshal(InputFieldWriter writer) throws IOException {
          writer.writeString("query", query);
        }
      };
    }
  }

  public static final class Builder {
    private @Nonnull String query;

    Builder() {
    }

    public Builder query(@Nonnull String query) {
      this.query = query;
      return this;
    }

    public SearchQuery build() {
      if (query == null) throw new IllegalStateException("query can't be null");
      return new SearchQuery(query);
    }
  }

  public static class Data implements Operation.Data {
    static final ResponseField[] $responseFields = {
      ResponseField.forObject("search", "search", new UnmodifiableMapBuilder<String, Object>(1)
        .put("query", new UnmodifiableMapBuilder<String, Object>(2)
          .put("kind", "Variable")
          .put("variableName", "query")
        .build())
      .build(), true)
    };

    final @Nullable Search search;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public Data(@Nullable Search search) {
      this.search = search;
    }

    public @Nullable Search search() {
      return this.search;
    }

    public ResponseFieldMarshaller marshaller() {
      return new ResponseFieldMarshaller() {
        @Override
        public void marshal(ResponseWriter writer) {
          writer.writeObject($responseFields[0], search != null ? search.marshaller() : null);
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "Data{"
          + "search=" + search
          + "}";
      }
      return $toString;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (o instanceof Data) {
        Data that = (Data) o;
        return ((this.search == null) ? (that.search == null) : this.search.equals(that.search));
      }
      return false;
    }

    @Override
    public int hashCode() {
      if (!$hashCodeMemoized) {
        int h = 1;
        h *= 1000003;
        h ^= (search == null) ? 0 : search.hashCode();
        $hashCode = h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    public static final class Mapper implements ResponseFieldMapper<Data> {
      final Search.Mapper searchFieldMapper = new Search.Mapper();

      @Override
      public Data map(ResponseReader reader) {
        final Search search = reader.readObject($responseFields[0], new ResponseReader.ObjectReader<Search>() {
          @Override
          public Search read(ResponseReader reader) {
            return searchFieldMapper.map(reader);
          }
        });
        return new Data(search);
      }
    }
  }

  public static class Search {
    static final ResponseField[] $responseFields = {
      ResponseField.forString("__typename", "__typename", null, false),
      ResponseField.forObject("nearestAntennaFromOrange", "nearestAntenna", new UnmodifiableMapBuilder<String, Object>(1)
        .put("provider", "ORANGE")
      .build(), true),
      ResponseField.forObject("nearestAntennaFromBouygues", "nearestAntenna", new UnmodifiableMapBuilder<String, Object>(1)
        .put("provider", "BOUYGUES_TELECOM")
      .build(), true),
      ResponseField.forObject("nearestAntennaFromSfr", "nearestAntenna", new UnmodifiableMapBuilder<String, Object>(1)
        .put("provider", "SFR")
      .build(), true),
      ResponseField.forObject("nearestAntennaFromFree", "nearestAntenna", new UnmodifiableMapBuilder<String, Object>(1)
        .put("provider", "FREE")
      .build(), true),
      ResponseField.forInlineFragment("__typename", "__typename", Arrays.asList("Street")),
      ResponseField.forInlineFragment("__typename", "__typename", Arrays.asList("City")),
      ResponseField.forInlineFragment("__typename", "__typename", Arrays.asList("HouseNumber"))
    };

    final @Nonnull String __typename;

    final @Nullable NearestAntennaFromOrange nearestAntennaFromOrange;

    final @Nullable NearestAntennaFromBouygues nearestAntennaFromBouygues;

    final @Nullable NearestAntennaFromSfr nearestAntennaFromSfr;

    final @Nullable NearestAntennaFromFree nearestAntennaFromFree;

    final @Nullable AsStreet asStreet;

    final @Nullable AsCity asCity;

    final @Nullable AsHouseNumber asHouseNumber;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public Search(@Nonnull String __typename,
        @Nullable NearestAntennaFromOrange nearestAntennaFromOrange,
        @Nullable NearestAntennaFromBouygues nearestAntennaFromBouygues,
        @Nullable NearestAntennaFromSfr nearestAntennaFromSfr,
        @Nullable NearestAntennaFromFree nearestAntennaFromFree, @Nullable AsStreet asStreet,
        @Nullable AsCity asCity, @Nullable AsHouseNumber asHouseNumber) {
      if (__typename == null) {
        throw new NullPointerException("__typename can't be null");
      }
      this.__typename = __typename;
      this.nearestAntennaFromOrange = nearestAntennaFromOrange;
      this.nearestAntennaFromBouygues = nearestAntennaFromBouygues;
      this.nearestAntennaFromSfr = nearestAntennaFromSfr;
      this.nearestAntennaFromFree = nearestAntennaFromFree;
      this.asStreet = asStreet;
      this.asCity = asCity;
      this.asHouseNumber = asHouseNumber;
    }

    public @Nonnull String __typename() {
      return this.__typename;
    }

    public @Nullable NearestAntennaFromOrange nearestAntennaFromOrange() {
      return this.nearestAntennaFromOrange;
    }

    public @Nullable NearestAntennaFromBouygues nearestAntennaFromBouygues() {
      return this.nearestAntennaFromBouygues;
    }

    public @Nullable NearestAntennaFromSfr nearestAntennaFromSfr() {
      return this.nearestAntennaFromSfr;
    }

    public @Nullable NearestAntennaFromFree nearestAntennaFromFree() {
      return this.nearestAntennaFromFree;
    }

    public @Nullable AsStreet asStreet() {
      return this.asStreet;
    }

    public @Nullable AsCity asCity() {
      return this.asCity;
    }

    public @Nullable AsHouseNumber asHouseNumber() {
      return this.asHouseNumber;
    }

    public ResponseFieldMarshaller marshaller() {
      return new ResponseFieldMarshaller() {
        @Override
        public void marshal(ResponseWriter writer) {
          writer.writeString($responseFields[0], __typename);
          writer.writeObject($responseFields[1], nearestAntennaFromOrange != null ? nearestAntennaFromOrange.marshaller() : null);
          writer.writeObject($responseFields[2], nearestAntennaFromBouygues != null ? nearestAntennaFromBouygues.marshaller() : null);
          writer.writeObject($responseFields[3], nearestAntennaFromSfr != null ? nearestAntennaFromSfr.marshaller() : null);
          writer.writeObject($responseFields[4], nearestAntennaFromFree != null ? nearestAntennaFromFree.marshaller() : null);
          final AsStreet $asStreet = asStreet;
          if ($asStreet != null) {
            $asStreet.marshaller().marshal(writer);
          }
          final AsCity $asCity = asCity;
          if ($asCity != null) {
            $asCity.marshaller().marshal(writer);
          }
          final AsHouseNumber $asHouseNumber = asHouseNumber;
          if ($asHouseNumber != null) {
            $asHouseNumber.marshaller().marshal(writer);
          }
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "Search{"
          + "__typename=" + __typename + ", "
          + "nearestAntennaFromOrange=" + nearestAntennaFromOrange + ", "
          + "nearestAntennaFromBouygues=" + nearestAntennaFromBouygues + ", "
          + "nearestAntennaFromSfr=" + nearestAntennaFromSfr + ", "
          + "nearestAntennaFromFree=" + nearestAntennaFromFree + ", "
          + "asStreet=" + asStreet + ", "
          + "asCity=" + asCity + ", "
          + "asHouseNumber=" + asHouseNumber
          + "}";
      }
      return $toString;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (o instanceof Search) {
        Search that = (Search) o;
        return this.__typename.equals(that.__typename)
         && ((this.nearestAntennaFromOrange == null) ? (that.nearestAntennaFromOrange == null) : this.nearestAntennaFromOrange.equals(that.nearestAntennaFromOrange))
         && ((this.nearestAntennaFromBouygues == null) ? (that.nearestAntennaFromBouygues == null) : this.nearestAntennaFromBouygues.equals(that.nearestAntennaFromBouygues))
         && ((this.nearestAntennaFromSfr == null) ? (that.nearestAntennaFromSfr == null) : this.nearestAntennaFromSfr.equals(that.nearestAntennaFromSfr))
         && ((this.nearestAntennaFromFree == null) ? (that.nearestAntennaFromFree == null) : this.nearestAntennaFromFree.equals(that.nearestAntennaFromFree))
         && ((this.asStreet == null) ? (that.asStreet == null) : this.asStreet.equals(that.asStreet))
         && ((this.asCity == null) ? (that.asCity == null) : this.asCity.equals(that.asCity))
         && ((this.asHouseNumber == null) ? (that.asHouseNumber == null) : this.asHouseNumber.equals(that.asHouseNumber));
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
        h ^= (nearestAntennaFromOrange == null) ? 0 : nearestAntennaFromOrange.hashCode();
        h *= 1000003;
        h ^= (nearestAntennaFromBouygues == null) ? 0 : nearestAntennaFromBouygues.hashCode();
        h *= 1000003;
        h ^= (nearestAntennaFromSfr == null) ? 0 : nearestAntennaFromSfr.hashCode();
        h *= 1000003;
        h ^= (nearestAntennaFromFree == null) ? 0 : nearestAntennaFromFree.hashCode();
        h *= 1000003;
        h ^= (asStreet == null) ? 0 : asStreet.hashCode();
        h *= 1000003;
        h ^= (asCity == null) ? 0 : asCity.hashCode();
        h *= 1000003;
        h ^= (asHouseNumber == null) ? 0 : asHouseNumber.hashCode();
        $hashCode = h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    public static final class Mapper implements ResponseFieldMapper<Search> {
      final NearestAntennaFromOrange.Mapper nearestAntennaFromOrangeFieldMapper = new NearestAntennaFromOrange.Mapper();

      final NearestAntennaFromBouygues.Mapper nearestAntennaFromBouyguesFieldMapper = new NearestAntennaFromBouygues.Mapper();

      final NearestAntennaFromSfr.Mapper nearestAntennaFromSfrFieldMapper = new NearestAntennaFromSfr.Mapper();

      final NearestAntennaFromFree.Mapper nearestAntennaFromFreeFieldMapper = new NearestAntennaFromFree.Mapper();

      final AsStreet.Mapper asStreetFieldMapper = new AsStreet.Mapper();

      final AsCity.Mapper asCityFieldMapper = new AsCity.Mapper();

      final AsHouseNumber.Mapper asHouseNumberFieldMapper = new AsHouseNumber.Mapper();

      @Override
      public Search map(ResponseReader reader) {
        final String __typename = reader.readString($responseFields[0]);
        final NearestAntennaFromOrange nearestAntennaFromOrange = reader.readObject($responseFields[1], new ResponseReader.ObjectReader<NearestAntennaFromOrange>() {
          @Override
          public NearestAntennaFromOrange read(ResponseReader reader) {
            return nearestAntennaFromOrangeFieldMapper.map(reader);
          }
        });
        final NearestAntennaFromBouygues nearestAntennaFromBouygues = reader.readObject($responseFields[2], new ResponseReader.ObjectReader<NearestAntennaFromBouygues>() {
          @Override
          public NearestAntennaFromBouygues read(ResponseReader reader) {
            return nearestAntennaFromBouyguesFieldMapper.map(reader);
          }
        });
        final NearestAntennaFromSfr nearestAntennaFromSfr = reader.readObject($responseFields[3], new ResponseReader.ObjectReader<NearestAntennaFromSfr>() {
          @Override
          public NearestAntennaFromSfr read(ResponseReader reader) {
            return nearestAntennaFromSfrFieldMapper.map(reader);
          }
        });
        final NearestAntennaFromFree nearestAntennaFromFree = reader.readObject($responseFields[4], new ResponseReader.ObjectReader<NearestAntennaFromFree>() {
          @Override
          public NearestAntennaFromFree read(ResponseReader reader) {
            return nearestAntennaFromFreeFieldMapper.map(reader);
          }
        });
        final AsStreet asStreet = reader.readConditional((ResponseField.ConditionalTypeField) $responseFields[5], new ResponseReader.ConditionalTypeReader<AsStreet>() {
          @Override
          public AsStreet read(String conditionalType, ResponseReader reader) {
            return asStreetFieldMapper.map(reader);
          }
        });
        final AsCity asCity = reader.readConditional((ResponseField.ConditionalTypeField) $responseFields[6], new ResponseReader.ConditionalTypeReader<AsCity>() {
          @Override
          public AsCity read(String conditionalType, ResponseReader reader) {
            return asCityFieldMapper.map(reader);
          }
        });
        final AsHouseNumber asHouseNumber = reader.readConditional((ResponseField.ConditionalTypeField) $responseFields[7], new ResponseReader.ConditionalTypeReader<AsHouseNumber>() {
          @Override
          public AsHouseNumber read(String conditionalType, ResponseReader reader) {
            return asHouseNumberFieldMapper.map(reader);
          }
        });
        return new Search(__typename, nearestAntennaFromOrange, nearestAntennaFromBouygues, nearestAntennaFromSfr, nearestAntennaFromFree, asStreet, asCity, asHouseNumber);
      }
    }
  }

  public static class NearestAntennaFromOrange {
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
      ResponseField.forString("addressLabel", "addressLabel", null, true),
      ResponseField.forFragment("__typename", "__typename", Arrays.asList("NearestAntenna"))
    };

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

    private final @Nonnull Fragments fragments;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public NearestAntennaFromOrange(@Nonnull String __typename, @Nullable Coordinates coordinates,
        @Nullable String generation, @Nullable String provider, @Nullable String lastUpdate,
        @Nullable String status, @Nullable Integer dist, @Nullable String insee,
        @Nullable String city, @Nullable String addressLabel, @Nonnull Fragments fragments) {
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
      if (fragments == null) {
        throw new NullPointerException("fragments can't be null");
      }
      this.fragments = fragments;
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

    public @Nonnull Fragments fragments() {
      return this.fragments;
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
          fragments.marshaller().marshal(writer);
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "NearestAntennaFromOrange{"
          + "__typename=" + __typename + ", "
          + "coordinates=" + coordinates + ", "
          + "generation=" + generation + ", "
          + "provider=" + provider + ", "
          + "lastUpdate=" + lastUpdate + ", "
          + "status=" + status + ", "
          + "dist=" + dist + ", "
          + "insee=" + insee + ", "
          + "city=" + city + ", "
          + "addressLabel=" + addressLabel + ", "
          + "fragments=" + fragments
          + "}";
      }
      return $toString;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (o instanceof NearestAntennaFromOrange) {
        NearestAntennaFromOrange that = (NearestAntennaFromOrange) o;
        return this.__typename.equals(that.__typename)
         && ((this.coordinates == null) ? (that.coordinates == null) : this.coordinates.equals(that.coordinates))
         && ((this.generation == null) ? (that.generation == null) : this.generation.equals(that.generation))
         && ((this.provider == null) ? (that.provider == null) : this.provider.equals(that.provider))
         && ((this.lastUpdate == null) ? (that.lastUpdate == null) : this.lastUpdate.equals(that.lastUpdate))
         && ((this.status == null) ? (that.status == null) : this.status.equals(that.status))
         && ((this.dist == null) ? (that.dist == null) : this.dist.equals(that.dist))
         && ((this.insee == null) ? (that.insee == null) : this.insee.equals(that.insee))
         && ((this.city == null) ? (that.city == null) : this.city.equals(that.city))
         && ((this.addressLabel == null) ? (that.addressLabel == null) : this.addressLabel.equals(that.addressLabel))
         && this.fragments.equals(that.fragments);
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
        h *= 1000003;
        h ^= fragments.hashCode();
        $hashCode = h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    public static class Fragments {
      final @Nonnull AntennaFields antennaFields;

      private volatile String $toString;

      private volatile int $hashCode;

      private volatile boolean $hashCodeMemoized;

      public Fragments(@Nonnull AntennaFields antennaFields) {
        if (antennaFields == null) {
          throw new NullPointerException("antennaFields can't be null");
        }
        this.antennaFields = antennaFields;
      }

      public @Nonnull AntennaFields antennaFields() {
        return this.antennaFields;
      }

      public ResponseFieldMarshaller marshaller() {
        return new ResponseFieldMarshaller() {
          @Override
          public void marshal(ResponseWriter writer) {
            final AntennaFields $antennaFields = antennaFields;
            if ($antennaFields != null) {
              $antennaFields.marshaller().marshal(writer);
            }
          }
        };
      }

      @Override
      public String toString() {
        if ($toString == null) {
          $toString = "Fragments{"
            + "antennaFields=" + antennaFields
            + "}";
        }
        return $toString;
      }

      @Override
      public boolean equals(Object o) {
        if (o == this) {
          return true;
        }
        if (o instanceof Fragments) {
          Fragments that = (Fragments) o;
          return this.antennaFields.equals(that.antennaFields);
        }
        return false;
      }

      @Override
      public int hashCode() {
        if (!$hashCodeMemoized) {
          int h = 1;
          h *= 1000003;
          h ^= antennaFields.hashCode();
          $hashCode = h;
          $hashCodeMemoized = true;
        }
        return $hashCode;
      }

      public static final class Mapper implements FragmentResponseFieldMapper<Fragments> {
        final AntennaFields.Mapper antennaFieldsFieldMapper = new AntennaFields.Mapper();

        @Override
        public @Nonnull Fragments map(ResponseReader reader, @Nonnull String conditionalType) {
          AntennaFields antennaFields = null;
          if (AntennaFields.POSSIBLE_TYPES.contains(conditionalType)) {
            antennaFields = antennaFieldsFieldMapper.map(reader);
          }
          return new Fragments(antennaFields);
        }
      }
    }

    public static final class Mapper implements ResponseFieldMapper<NearestAntennaFromOrange> {
      final Coordinates.Mapper coordinatesFieldMapper = new Coordinates.Mapper();

      final Fragments.Mapper fragmentsFieldMapper = new Fragments.Mapper();

      @Override
      public NearestAntennaFromOrange map(ResponseReader reader) {
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
        final Fragments fragments = reader.readConditional((ResponseField.ConditionalTypeField) $responseFields[10], new ResponseReader.ConditionalTypeReader<Fragments>() {
          @Override
          public Fragments read(String conditionalType, ResponseReader reader) {
            return fragmentsFieldMapper.map(reader, conditionalType);
          }
        });
        return new NearestAntennaFromOrange(__typename, coordinates, generation, provider, lastUpdate, status, dist, insee, city, addressLabel, fragments);
      }
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

  public static class NearestAntennaFromBouygues {
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
      ResponseField.forString("addressLabel", "addressLabel", null, true),
      ResponseField.forFragment("__typename", "__typename", Arrays.asList("NearestAntenna"))
    };

    final @Nonnull String __typename;

    final @Nullable Coordinates1 coordinates;

    final @Nullable String generation;

    final @Nullable String provider;

    final @Nullable String lastUpdate;

    final @Nullable String status;

    final @Nullable Integer dist;

    final @Nullable String insee;

    final @Nullable String city;

    final @Nullable String addressLabel;

    private final @Nonnull Fragments fragments;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public NearestAntennaFromBouygues(@Nonnull String __typename,
        @Nullable Coordinates1 coordinates, @Nullable String generation, @Nullable String provider,
        @Nullable String lastUpdate, @Nullable String status, @Nullable Integer dist,
        @Nullable String insee, @Nullable String city, @Nullable String addressLabel,
        @Nonnull Fragments fragments) {
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
      if (fragments == null) {
        throw new NullPointerException("fragments can't be null");
      }
      this.fragments = fragments;
    }

    public @Nonnull String __typename() {
      return this.__typename;
    }

    public @Nullable Coordinates1 coordinates() {
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

    public @Nonnull Fragments fragments() {
      return this.fragments;
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
          fragments.marshaller().marshal(writer);
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "NearestAntennaFromBouygues{"
          + "__typename=" + __typename + ", "
          + "coordinates=" + coordinates + ", "
          + "generation=" + generation + ", "
          + "provider=" + provider + ", "
          + "lastUpdate=" + lastUpdate + ", "
          + "status=" + status + ", "
          + "dist=" + dist + ", "
          + "insee=" + insee + ", "
          + "city=" + city + ", "
          + "addressLabel=" + addressLabel + ", "
          + "fragments=" + fragments
          + "}";
      }
      return $toString;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (o instanceof NearestAntennaFromBouygues) {
        NearestAntennaFromBouygues that = (NearestAntennaFromBouygues) o;
        return this.__typename.equals(that.__typename)
         && ((this.coordinates == null) ? (that.coordinates == null) : this.coordinates.equals(that.coordinates))
         && ((this.generation == null) ? (that.generation == null) : this.generation.equals(that.generation))
         && ((this.provider == null) ? (that.provider == null) : this.provider.equals(that.provider))
         && ((this.lastUpdate == null) ? (that.lastUpdate == null) : this.lastUpdate.equals(that.lastUpdate))
         && ((this.status == null) ? (that.status == null) : this.status.equals(that.status))
         && ((this.dist == null) ? (that.dist == null) : this.dist.equals(that.dist))
         && ((this.insee == null) ? (that.insee == null) : this.insee.equals(that.insee))
         && ((this.city == null) ? (that.city == null) : this.city.equals(that.city))
         && ((this.addressLabel == null) ? (that.addressLabel == null) : this.addressLabel.equals(that.addressLabel))
         && this.fragments.equals(that.fragments);
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
        h *= 1000003;
        h ^= fragments.hashCode();
        $hashCode = h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    public static class Fragments {
      final @Nonnull AntennaFields antennaFields;

      private volatile String $toString;

      private volatile int $hashCode;

      private volatile boolean $hashCodeMemoized;

      public Fragments(@Nonnull AntennaFields antennaFields) {
        if (antennaFields == null) {
          throw new NullPointerException("antennaFields can't be null");
        }
        this.antennaFields = antennaFields;
      }

      public @Nonnull AntennaFields antennaFields() {
        return this.antennaFields;
      }

      public ResponseFieldMarshaller marshaller() {
        return new ResponseFieldMarshaller() {
          @Override
          public void marshal(ResponseWriter writer) {
            final AntennaFields $antennaFields = antennaFields;
            if ($antennaFields != null) {
              $antennaFields.marshaller().marshal(writer);
            }
          }
        };
      }

      @Override
      public String toString() {
        if ($toString == null) {
          $toString = "Fragments{"
            + "antennaFields=" + antennaFields
            + "}";
        }
        return $toString;
      }

      @Override
      public boolean equals(Object o) {
        if (o == this) {
          return true;
        }
        if (o instanceof Fragments) {
          Fragments that = (Fragments) o;
          return this.antennaFields.equals(that.antennaFields);
        }
        return false;
      }

      @Override
      public int hashCode() {
        if (!$hashCodeMemoized) {
          int h = 1;
          h *= 1000003;
          h ^= antennaFields.hashCode();
          $hashCode = h;
          $hashCodeMemoized = true;
        }
        return $hashCode;
      }

      public static final class Mapper implements FragmentResponseFieldMapper<Fragments> {
        final AntennaFields.Mapper antennaFieldsFieldMapper = new AntennaFields.Mapper();

        @Override
        public @Nonnull Fragments map(ResponseReader reader, @Nonnull String conditionalType) {
          AntennaFields antennaFields = null;
          if (AntennaFields.POSSIBLE_TYPES.contains(conditionalType)) {
            antennaFields = antennaFieldsFieldMapper.map(reader);
          }
          return new Fragments(antennaFields);
        }
      }
    }

    public static final class Mapper implements ResponseFieldMapper<NearestAntennaFromBouygues> {
      final Coordinates1.Mapper coordinates1FieldMapper = new Coordinates1.Mapper();

      final Fragments.Mapper fragmentsFieldMapper = new Fragments.Mapper();

      @Override
      public NearestAntennaFromBouygues map(ResponseReader reader) {
        final String __typename = reader.readString($responseFields[0]);
        final Coordinates1 coordinates = reader.readObject($responseFields[1], new ResponseReader.ObjectReader<Coordinates1>() {
          @Override
          public Coordinates1 read(ResponseReader reader) {
            return coordinates1FieldMapper.map(reader);
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
        final Fragments fragments = reader.readConditional((ResponseField.ConditionalTypeField) $responseFields[10], new ResponseReader.ConditionalTypeReader<Fragments>() {
          @Override
          public Fragments read(String conditionalType, ResponseReader reader) {
            return fragmentsFieldMapper.map(reader, conditionalType);
          }
        });
        return new NearestAntennaFromBouygues(__typename, coordinates, generation, provider, lastUpdate, status, dist, insee, city, addressLabel, fragments);
      }
    }
  }

  public static class Coordinates1 {
    static final ResponseField[] $responseFields = {
      ResponseField.forDouble("latitude", "latitude", null, true),
      ResponseField.forDouble("longitude", "longitude", null, true)
    };

    final @Nullable Double latitude;

    final @Nullable Double longitude;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public Coordinates1(@Nullable Double latitude, @Nullable Double longitude) {
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
        $toString = "Coordinates1{"
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
      if (o instanceof Coordinates1) {
        Coordinates1 that = (Coordinates1) o;
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

    public static final class Mapper implements ResponseFieldMapper<Coordinates1> {
      @Override
      public Coordinates1 map(ResponseReader reader) {
        final Double latitude = reader.readDouble($responseFields[0]);
        final Double longitude = reader.readDouble($responseFields[1]);
        return new Coordinates1(latitude, longitude);
      }
    }
  }

  public static class NearestAntennaFromSfr {
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
      ResponseField.forString("addressLabel", "addressLabel", null, true),
      ResponseField.forFragment("__typename", "__typename", Arrays.asList("NearestAntenna"))
    };

    final @Nonnull String __typename;

    final @Nullable Coordinates2 coordinates;

    final @Nullable String generation;

    final @Nullable String provider;

    final @Nullable String lastUpdate;

    final @Nullable String status;

    final @Nullable Integer dist;

    final @Nullable String insee;

    final @Nullable String city;

    final @Nullable String addressLabel;

    private final @Nonnull Fragments fragments;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public NearestAntennaFromSfr(@Nonnull String __typename, @Nullable Coordinates2 coordinates,
        @Nullable String generation, @Nullable String provider, @Nullable String lastUpdate,
        @Nullable String status, @Nullable Integer dist, @Nullable String insee,
        @Nullable String city, @Nullable String addressLabel, @Nonnull Fragments fragments) {
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
      if (fragments == null) {
        throw new NullPointerException("fragments can't be null");
      }
      this.fragments = fragments;
    }

    public @Nonnull String __typename() {
      return this.__typename;
    }

    public @Nullable Coordinates2 coordinates() {
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

    public @Nonnull Fragments fragments() {
      return this.fragments;
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
          fragments.marshaller().marshal(writer);
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "NearestAntennaFromSfr{"
          + "__typename=" + __typename + ", "
          + "coordinates=" + coordinates + ", "
          + "generation=" + generation + ", "
          + "provider=" + provider + ", "
          + "lastUpdate=" + lastUpdate + ", "
          + "status=" + status + ", "
          + "dist=" + dist + ", "
          + "insee=" + insee + ", "
          + "city=" + city + ", "
          + "addressLabel=" + addressLabel + ", "
          + "fragments=" + fragments
          + "}";
      }
      return $toString;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (o instanceof NearestAntennaFromSfr) {
        NearestAntennaFromSfr that = (NearestAntennaFromSfr) o;
        return this.__typename.equals(that.__typename)
         && ((this.coordinates == null) ? (that.coordinates == null) : this.coordinates.equals(that.coordinates))
         && ((this.generation == null) ? (that.generation == null) : this.generation.equals(that.generation))
         && ((this.provider == null) ? (that.provider == null) : this.provider.equals(that.provider))
         && ((this.lastUpdate == null) ? (that.lastUpdate == null) : this.lastUpdate.equals(that.lastUpdate))
         && ((this.status == null) ? (that.status == null) : this.status.equals(that.status))
         && ((this.dist == null) ? (that.dist == null) : this.dist.equals(that.dist))
         && ((this.insee == null) ? (that.insee == null) : this.insee.equals(that.insee))
         && ((this.city == null) ? (that.city == null) : this.city.equals(that.city))
         && ((this.addressLabel == null) ? (that.addressLabel == null) : this.addressLabel.equals(that.addressLabel))
         && this.fragments.equals(that.fragments);
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
        h *= 1000003;
        h ^= fragments.hashCode();
        $hashCode = h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    public static class Fragments {
      final @Nonnull AntennaFields antennaFields;

      private volatile String $toString;

      private volatile int $hashCode;

      private volatile boolean $hashCodeMemoized;

      public Fragments(@Nonnull AntennaFields antennaFields) {
        if (antennaFields == null) {
          throw new NullPointerException("antennaFields can't be null");
        }
        this.antennaFields = antennaFields;
      }

      public @Nonnull AntennaFields antennaFields() {
        return this.antennaFields;
      }

      public ResponseFieldMarshaller marshaller() {
        return new ResponseFieldMarshaller() {
          @Override
          public void marshal(ResponseWriter writer) {
            final AntennaFields $antennaFields = antennaFields;
            if ($antennaFields != null) {
              $antennaFields.marshaller().marshal(writer);
            }
          }
        };
      }

      @Override
      public String toString() {
        if ($toString == null) {
          $toString = "Fragments{"
            + "antennaFields=" + antennaFields
            + "}";
        }
        return $toString;
      }

      @Override
      public boolean equals(Object o) {
        if (o == this) {
          return true;
        }
        if (o instanceof Fragments) {
          Fragments that = (Fragments) o;
          return this.antennaFields.equals(that.antennaFields);
        }
        return false;
      }

      @Override
      public int hashCode() {
        if (!$hashCodeMemoized) {
          int h = 1;
          h *= 1000003;
          h ^= antennaFields.hashCode();
          $hashCode = h;
          $hashCodeMemoized = true;
        }
        return $hashCode;
      }

      public static final class Mapper implements FragmentResponseFieldMapper<Fragments> {
        final AntennaFields.Mapper antennaFieldsFieldMapper = new AntennaFields.Mapper();

        @Override
        public @Nonnull Fragments map(ResponseReader reader, @Nonnull String conditionalType) {
          AntennaFields antennaFields = null;
          if (AntennaFields.POSSIBLE_TYPES.contains(conditionalType)) {
            antennaFields = antennaFieldsFieldMapper.map(reader);
          }
          return new Fragments(antennaFields);
        }
      }
    }

    public static final class Mapper implements ResponseFieldMapper<NearestAntennaFromSfr> {
      final Coordinates2.Mapper coordinates2FieldMapper = new Coordinates2.Mapper();

      final Fragments.Mapper fragmentsFieldMapper = new Fragments.Mapper();

      @Override
      public NearestAntennaFromSfr map(ResponseReader reader) {
        final String __typename = reader.readString($responseFields[0]);
        final Coordinates2 coordinates = reader.readObject($responseFields[1], new ResponseReader.ObjectReader<Coordinates2>() {
          @Override
          public Coordinates2 read(ResponseReader reader) {
            return coordinates2FieldMapper.map(reader);
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
        final Fragments fragments = reader.readConditional((ResponseField.ConditionalTypeField) $responseFields[10], new ResponseReader.ConditionalTypeReader<Fragments>() {
          @Override
          public Fragments read(String conditionalType, ResponseReader reader) {
            return fragmentsFieldMapper.map(reader, conditionalType);
          }
        });
        return new NearestAntennaFromSfr(__typename, coordinates, generation, provider, lastUpdate, status, dist, insee, city, addressLabel, fragments);
      }
    }
  }

  public static class Coordinates2 {
    static final ResponseField[] $responseFields = {
      ResponseField.forDouble("latitude", "latitude", null, true),
      ResponseField.forDouble("longitude", "longitude", null, true)
    };

    final @Nullable Double latitude;

    final @Nullable Double longitude;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public Coordinates2(@Nullable Double latitude, @Nullable Double longitude) {
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
        $toString = "Coordinates2{"
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
      if (o instanceof Coordinates2) {
        Coordinates2 that = (Coordinates2) o;
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

    public static final class Mapper implements ResponseFieldMapper<Coordinates2> {
      @Override
      public Coordinates2 map(ResponseReader reader) {
        final Double latitude = reader.readDouble($responseFields[0]);
        final Double longitude = reader.readDouble($responseFields[1]);
        return new Coordinates2(latitude, longitude);
      }
    }
  }

  public static class NearestAntennaFromFree {
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
      ResponseField.forString("addressLabel", "addressLabel", null, true),
      ResponseField.forFragment("__typename", "__typename", Arrays.asList("NearestAntenna"))
    };

    final @Nonnull String __typename;

    final @Nullable Coordinates3 coordinates;

    final @Nullable String generation;

    final @Nullable String provider;

    final @Nullable String lastUpdate;

    final @Nullable String status;

    final @Nullable Integer dist;

    final @Nullable String insee;

    final @Nullable String city;

    final @Nullable String addressLabel;

    private final @Nonnull Fragments fragments;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public NearestAntennaFromFree(@Nonnull String __typename, @Nullable Coordinates3 coordinates,
        @Nullable String generation, @Nullable String provider, @Nullable String lastUpdate,
        @Nullable String status, @Nullable Integer dist, @Nullable String insee,
        @Nullable String city, @Nullable String addressLabel, @Nonnull Fragments fragments) {
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
      if (fragments == null) {
        throw new NullPointerException("fragments can't be null");
      }
      this.fragments = fragments;
    }

    public @Nonnull String __typename() {
      return this.__typename;
    }

    public @Nullable Coordinates3 coordinates() {
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

    public @Nonnull Fragments fragments() {
      return this.fragments;
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
          fragments.marshaller().marshal(writer);
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "NearestAntennaFromFree{"
          + "__typename=" + __typename + ", "
          + "coordinates=" + coordinates + ", "
          + "generation=" + generation + ", "
          + "provider=" + provider + ", "
          + "lastUpdate=" + lastUpdate + ", "
          + "status=" + status + ", "
          + "dist=" + dist + ", "
          + "insee=" + insee + ", "
          + "city=" + city + ", "
          + "addressLabel=" + addressLabel + ", "
          + "fragments=" + fragments
          + "}";
      }
      return $toString;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (o instanceof NearestAntennaFromFree) {
        NearestAntennaFromFree that = (NearestAntennaFromFree) o;
        return this.__typename.equals(that.__typename)
         && ((this.coordinates == null) ? (that.coordinates == null) : this.coordinates.equals(that.coordinates))
         && ((this.generation == null) ? (that.generation == null) : this.generation.equals(that.generation))
         && ((this.provider == null) ? (that.provider == null) : this.provider.equals(that.provider))
         && ((this.lastUpdate == null) ? (that.lastUpdate == null) : this.lastUpdate.equals(that.lastUpdate))
         && ((this.status == null) ? (that.status == null) : this.status.equals(that.status))
         && ((this.dist == null) ? (that.dist == null) : this.dist.equals(that.dist))
         && ((this.insee == null) ? (that.insee == null) : this.insee.equals(that.insee))
         && ((this.city == null) ? (that.city == null) : this.city.equals(that.city))
         && ((this.addressLabel == null) ? (that.addressLabel == null) : this.addressLabel.equals(that.addressLabel))
         && this.fragments.equals(that.fragments);
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
        h *= 1000003;
        h ^= fragments.hashCode();
        $hashCode = h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    public static class Fragments {
      final @Nonnull AntennaFields antennaFields;

      private volatile String $toString;

      private volatile int $hashCode;

      private volatile boolean $hashCodeMemoized;

      public Fragments(@Nonnull AntennaFields antennaFields) {
        if (antennaFields == null) {
          throw new NullPointerException("antennaFields can't be null");
        }
        this.antennaFields = antennaFields;
      }

      public @Nonnull AntennaFields antennaFields() {
        return this.antennaFields;
      }

      public ResponseFieldMarshaller marshaller() {
        return new ResponseFieldMarshaller() {
          @Override
          public void marshal(ResponseWriter writer) {
            final AntennaFields $antennaFields = antennaFields;
            if ($antennaFields != null) {
              $antennaFields.marshaller().marshal(writer);
            }
          }
        };
      }

      @Override
      public String toString() {
        if ($toString == null) {
          $toString = "Fragments{"
            + "antennaFields=" + antennaFields
            + "}";
        }
        return $toString;
      }

      @Override
      public boolean equals(Object o) {
        if (o == this) {
          return true;
        }
        if (o instanceof Fragments) {
          Fragments that = (Fragments) o;
          return this.antennaFields.equals(that.antennaFields);
        }
        return false;
      }

      @Override
      public int hashCode() {
        if (!$hashCodeMemoized) {
          int h = 1;
          h *= 1000003;
          h ^= antennaFields.hashCode();
          $hashCode = h;
          $hashCodeMemoized = true;
        }
        return $hashCode;
      }

      public static final class Mapper implements FragmentResponseFieldMapper<Fragments> {
        final AntennaFields.Mapper antennaFieldsFieldMapper = new AntennaFields.Mapper();

        @Override
        public @Nonnull Fragments map(ResponseReader reader, @Nonnull String conditionalType) {
          AntennaFields antennaFields = null;
          if (AntennaFields.POSSIBLE_TYPES.contains(conditionalType)) {
            antennaFields = antennaFieldsFieldMapper.map(reader);
          }
          return new Fragments(antennaFields);
        }
      }
    }

    public static final class Mapper implements ResponseFieldMapper<NearestAntennaFromFree> {
      final Coordinates3.Mapper coordinates3FieldMapper = new Coordinates3.Mapper();

      final Fragments.Mapper fragmentsFieldMapper = new Fragments.Mapper();

      @Override
      public NearestAntennaFromFree map(ResponseReader reader) {
        final String __typename = reader.readString($responseFields[0]);
        final Coordinates3 coordinates = reader.readObject($responseFields[1], new ResponseReader.ObjectReader<Coordinates3>() {
          @Override
          public Coordinates3 read(ResponseReader reader) {
            return coordinates3FieldMapper.map(reader);
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
        final Fragments fragments = reader.readConditional((ResponseField.ConditionalTypeField) $responseFields[10], new ResponseReader.ConditionalTypeReader<Fragments>() {
          @Override
          public Fragments read(String conditionalType, ResponseReader reader) {
            return fragmentsFieldMapper.map(reader, conditionalType);
          }
        });
        return new NearestAntennaFromFree(__typename, coordinates, generation, provider, lastUpdate, status, dist, insee, city, addressLabel, fragments);
      }
    }
  }

  public static class Coordinates3 {
    static final ResponseField[] $responseFields = {
      ResponseField.forDouble("latitude", "latitude", null, true),
      ResponseField.forDouble("longitude", "longitude", null, true)
    };

    final @Nullable Double latitude;

    final @Nullable Double longitude;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public Coordinates3(@Nullable Double latitude, @Nullable Double longitude) {
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
        $toString = "Coordinates3{"
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
      if (o instanceof Coordinates3) {
        Coordinates3 that = (Coordinates3) o;
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

    public static final class Mapper implements ResponseFieldMapper<Coordinates3> {
      @Override
      public Coordinates3 map(ResponseReader reader) {
        final Double latitude = reader.readDouble($responseFields[0]);
        final Double longitude = reader.readDouble($responseFields[1]);
        return new Coordinates3(latitude, longitude);
      }
    }
  }

  public static class AsStreet {
    static final ResponseField[] $responseFields = {
      ResponseField.forString("__typename", "__typename", null, false),
      ResponseField.forString("street", "street", null, true),
      ResponseField.forString("city", "city", null, true),
      ResponseField.forString("zipCode", "zipCode", null, true),
      ResponseField.forObject("nearestAntennaFromOrange", "nearestAntenna", new UnmodifiableMapBuilder<String, Object>(1)
        .put("provider", "ORANGE")
      .build(), true),
      ResponseField.forObject("nearestAntennaFromBouygues", "nearestAntenna", new UnmodifiableMapBuilder<String, Object>(1)
        .put("provider", "BOUYGUES_TELECOM")
      .build(), true),
      ResponseField.forObject("nearestAntennaFromSfr", "nearestAntenna", new UnmodifiableMapBuilder<String, Object>(1)
        .put("provider", "SFR")
      .build(), true),
      ResponseField.forObject("nearestAntennaFromFree", "nearestAntenna", new UnmodifiableMapBuilder<String, Object>(1)
        .put("provider", "FREE")
      .build(), true)
    };

    final @Nonnull String __typename;

    final @Nullable String street;

    final @Nullable String city;

    final @Nullable String zipCode;

    final @Nullable NearestAntennaFromOrange1 nearestAntennaFromOrange;

    final @Nullable NearestAntennaFromBouygues1 nearestAntennaFromBouygues;

    final @Nullable NearestAntennaFromSfr1 nearestAntennaFromSfr;

    final @Nullable NearestAntennaFromFree1 nearestAntennaFromFree;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public AsStreet(@Nonnull String __typename, @Nullable String street, @Nullable String city,
        @Nullable String zipCode, @Nullable NearestAntennaFromOrange1 nearestAntennaFromOrange,
        @Nullable NearestAntennaFromBouygues1 nearestAntennaFromBouygues,
        @Nullable NearestAntennaFromSfr1 nearestAntennaFromSfr,
        @Nullable NearestAntennaFromFree1 nearestAntennaFromFree) {
      if (__typename == null) {
        throw new NullPointerException("__typename can't be null");
      }
      this.__typename = __typename;
      this.street = street;
      this.city = city;
      this.zipCode = zipCode;
      this.nearestAntennaFromOrange = nearestAntennaFromOrange;
      this.nearestAntennaFromBouygues = nearestAntennaFromBouygues;
      this.nearestAntennaFromSfr = nearestAntennaFromSfr;
      this.nearestAntennaFromFree = nearestAntennaFromFree;
    }

    public @Nonnull String __typename() {
      return this.__typename;
    }

    public @Nullable String street() {
      return this.street;
    }

    public @Nullable String city() {
      return this.city;
    }

    public @Nullable String zipCode() {
      return this.zipCode;
    }

    public @Nullable NearestAntennaFromOrange1 nearestAntennaFromOrange() {
      return this.nearestAntennaFromOrange;
    }

    public @Nullable NearestAntennaFromBouygues1 nearestAntennaFromBouygues() {
      return this.nearestAntennaFromBouygues;
    }

    public @Nullable NearestAntennaFromSfr1 nearestAntennaFromSfr() {
      return this.nearestAntennaFromSfr;
    }

    public @Nullable NearestAntennaFromFree1 nearestAntennaFromFree() {
      return this.nearestAntennaFromFree;
    }

    public ResponseFieldMarshaller marshaller() {
      return new ResponseFieldMarshaller() {
        @Override
        public void marshal(ResponseWriter writer) {
          writer.writeString($responseFields[0], __typename);
          writer.writeString($responseFields[1], street);
          writer.writeString($responseFields[2], city);
          writer.writeString($responseFields[3], zipCode);
          writer.writeObject($responseFields[4], nearestAntennaFromOrange != null ? nearestAntennaFromOrange.marshaller() : null);
          writer.writeObject($responseFields[5], nearestAntennaFromBouygues != null ? nearestAntennaFromBouygues.marshaller() : null);
          writer.writeObject($responseFields[6], nearestAntennaFromSfr != null ? nearestAntennaFromSfr.marshaller() : null);
          writer.writeObject($responseFields[7], nearestAntennaFromFree != null ? nearestAntennaFromFree.marshaller() : null);
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "AsStreet{"
          + "__typename=" + __typename + ", "
          + "street=" + street + ", "
          + "city=" + city + ", "
          + "zipCode=" + zipCode + ", "
          + "nearestAntennaFromOrange=" + nearestAntennaFromOrange + ", "
          + "nearestAntennaFromBouygues=" + nearestAntennaFromBouygues + ", "
          + "nearestAntennaFromSfr=" + nearestAntennaFromSfr + ", "
          + "nearestAntennaFromFree=" + nearestAntennaFromFree
          + "}";
      }
      return $toString;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (o instanceof AsStreet) {
        AsStreet that = (AsStreet) o;
        return this.__typename.equals(that.__typename)
         && ((this.street == null) ? (that.street == null) : this.street.equals(that.street))
         && ((this.city == null) ? (that.city == null) : this.city.equals(that.city))
         && ((this.zipCode == null) ? (that.zipCode == null) : this.zipCode.equals(that.zipCode))
         && ((this.nearestAntennaFromOrange == null) ? (that.nearestAntennaFromOrange == null) : this.nearestAntennaFromOrange.equals(that.nearestAntennaFromOrange))
         && ((this.nearestAntennaFromBouygues == null) ? (that.nearestAntennaFromBouygues == null) : this.nearestAntennaFromBouygues.equals(that.nearestAntennaFromBouygues))
         && ((this.nearestAntennaFromSfr == null) ? (that.nearestAntennaFromSfr == null) : this.nearestAntennaFromSfr.equals(that.nearestAntennaFromSfr))
         && ((this.nearestAntennaFromFree == null) ? (that.nearestAntennaFromFree == null) : this.nearestAntennaFromFree.equals(that.nearestAntennaFromFree));
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
        h ^= (street == null) ? 0 : street.hashCode();
        h *= 1000003;
        h ^= (city == null) ? 0 : city.hashCode();
        h *= 1000003;
        h ^= (zipCode == null) ? 0 : zipCode.hashCode();
        h *= 1000003;
        h ^= (nearestAntennaFromOrange == null) ? 0 : nearestAntennaFromOrange.hashCode();
        h *= 1000003;
        h ^= (nearestAntennaFromBouygues == null) ? 0 : nearestAntennaFromBouygues.hashCode();
        h *= 1000003;
        h ^= (nearestAntennaFromSfr == null) ? 0 : nearestAntennaFromSfr.hashCode();
        h *= 1000003;
        h ^= (nearestAntennaFromFree == null) ? 0 : nearestAntennaFromFree.hashCode();
        $hashCode = h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    public static final class Mapper implements ResponseFieldMapper<AsStreet> {
      final NearestAntennaFromOrange1.Mapper nearestAntennaFromOrange1FieldMapper = new NearestAntennaFromOrange1.Mapper();

      final NearestAntennaFromBouygues1.Mapper nearestAntennaFromBouygues1FieldMapper = new NearestAntennaFromBouygues1.Mapper();

      final NearestAntennaFromSfr1.Mapper nearestAntennaFromSfr1FieldMapper = new NearestAntennaFromSfr1.Mapper();

      final NearestAntennaFromFree1.Mapper nearestAntennaFromFree1FieldMapper = new NearestAntennaFromFree1.Mapper();

      @Override
      public AsStreet map(ResponseReader reader) {
        final String __typename = reader.readString($responseFields[0]);
        final String street = reader.readString($responseFields[1]);
        final String city = reader.readString($responseFields[2]);
        final String zipCode = reader.readString($responseFields[3]);
        final NearestAntennaFromOrange1 nearestAntennaFromOrange = reader.readObject($responseFields[4], new ResponseReader.ObjectReader<NearestAntennaFromOrange1>() {
          @Override
          public NearestAntennaFromOrange1 read(ResponseReader reader) {
            return nearestAntennaFromOrange1FieldMapper.map(reader);
          }
        });
        final NearestAntennaFromBouygues1 nearestAntennaFromBouygues = reader.readObject($responseFields[5], new ResponseReader.ObjectReader<NearestAntennaFromBouygues1>() {
          @Override
          public NearestAntennaFromBouygues1 read(ResponseReader reader) {
            return nearestAntennaFromBouygues1FieldMapper.map(reader);
          }
        });
        final NearestAntennaFromSfr1 nearestAntennaFromSfr = reader.readObject($responseFields[6], new ResponseReader.ObjectReader<NearestAntennaFromSfr1>() {
          @Override
          public NearestAntennaFromSfr1 read(ResponseReader reader) {
            return nearestAntennaFromSfr1FieldMapper.map(reader);
          }
        });
        final NearestAntennaFromFree1 nearestAntennaFromFree = reader.readObject($responseFields[7], new ResponseReader.ObjectReader<NearestAntennaFromFree1>() {
          @Override
          public NearestAntennaFromFree1 read(ResponseReader reader) {
            return nearestAntennaFromFree1FieldMapper.map(reader);
          }
        });
        return new AsStreet(__typename, street, city, zipCode, nearestAntennaFromOrange, nearestAntennaFromBouygues, nearestAntennaFromSfr, nearestAntennaFromFree);
      }
    }
  }

  public static class NearestAntennaFromOrange1 {
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
      ResponseField.forString("addressLabel", "addressLabel", null, true),
      ResponseField.forFragment("__typename", "__typename", Arrays.asList("NearestAntenna"))
    };

    final @Nonnull String __typename;

    final @Nullable Coordinates4 coordinates;

    final @Nullable String generation;

    final @Nullable String provider;

    final @Nullable String lastUpdate;

    final @Nullable String status;

    final @Nullable Integer dist;

    final @Nullable String insee;

    final @Nullable String city;

    final @Nullable String addressLabel;

    private final @Nonnull Fragments fragments;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public NearestAntennaFromOrange1(@Nonnull String __typename, @Nullable Coordinates4 coordinates,
        @Nullable String generation, @Nullable String provider, @Nullable String lastUpdate,
        @Nullable String status, @Nullable Integer dist, @Nullable String insee,
        @Nullable String city, @Nullable String addressLabel, @Nonnull Fragments fragments) {
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
      if (fragments == null) {
        throw new NullPointerException("fragments can't be null");
      }
      this.fragments = fragments;
    }

    public @Nonnull String __typename() {
      return this.__typename;
    }

    public @Nullable Coordinates4 coordinates() {
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

    public @Nonnull Fragments fragments() {
      return this.fragments;
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
          fragments.marshaller().marshal(writer);
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "NearestAntennaFromOrange1{"
          + "__typename=" + __typename + ", "
          + "coordinates=" + coordinates + ", "
          + "generation=" + generation + ", "
          + "provider=" + provider + ", "
          + "lastUpdate=" + lastUpdate + ", "
          + "status=" + status + ", "
          + "dist=" + dist + ", "
          + "insee=" + insee + ", "
          + "city=" + city + ", "
          + "addressLabel=" + addressLabel + ", "
          + "fragments=" + fragments
          + "}";
      }
      return $toString;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (o instanceof NearestAntennaFromOrange1) {
        NearestAntennaFromOrange1 that = (NearestAntennaFromOrange1) o;
        return this.__typename.equals(that.__typename)
         && ((this.coordinates == null) ? (that.coordinates == null) : this.coordinates.equals(that.coordinates))
         && ((this.generation == null) ? (that.generation == null) : this.generation.equals(that.generation))
         && ((this.provider == null) ? (that.provider == null) : this.provider.equals(that.provider))
         && ((this.lastUpdate == null) ? (that.lastUpdate == null) : this.lastUpdate.equals(that.lastUpdate))
         && ((this.status == null) ? (that.status == null) : this.status.equals(that.status))
         && ((this.dist == null) ? (that.dist == null) : this.dist.equals(that.dist))
         && ((this.insee == null) ? (that.insee == null) : this.insee.equals(that.insee))
         && ((this.city == null) ? (that.city == null) : this.city.equals(that.city))
         && ((this.addressLabel == null) ? (that.addressLabel == null) : this.addressLabel.equals(that.addressLabel))
         && this.fragments.equals(that.fragments);
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
        h *= 1000003;
        h ^= fragments.hashCode();
        $hashCode = h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    public static class Fragments {
      final @Nonnull AntennaFields antennaFields;

      private volatile String $toString;

      private volatile int $hashCode;

      private volatile boolean $hashCodeMemoized;

      public Fragments(@Nonnull AntennaFields antennaFields) {
        if (antennaFields == null) {
          throw new NullPointerException("antennaFields can't be null");
        }
        this.antennaFields = antennaFields;
      }

      public @Nonnull AntennaFields antennaFields() {
        return this.antennaFields;
      }

      public ResponseFieldMarshaller marshaller() {
        return new ResponseFieldMarshaller() {
          @Override
          public void marshal(ResponseWriter writer) {
            final AntennaFields $antennaFields = antennaFields;
            if ($antennaFields != null) {
              $antennaFields.marshaller().marshal(writer);
            }
          }
        };
      }

      @Override
      public String toString() {
        if ($toString == null) {
          $toString = "Fragments{"
            + "antennaFields=" + antennaFields
            + "}";
        }
        return $toString;
      }

      @Override
      public boolean equals(Object o) {
        if (o == this) {
          return true;
        }
        if (o instanceof Fragments) {
          Fragments that = (Fragments) o;
          return this.antennaFields.equals(that.antennaFields);
        }
        return false;
      }

      @Override
      public int hashCode() {
        if (!$hashCodeMemoized) {
          int h = 1;
          h *= 1000003;
          h ^= antennaFields.hashCode();
          $hashCode = h;
          $hashCodeMemoized = true;
        }
        return $hashCode;
      }

      public static final class Mapper implements FragmentResponseFieldMapper<Fragments> {
        final AntennaFields.Mapper antennaFieldsFieldMapper = new AntennaFields.Mapper();

        @Override
        public @Nonnull Fragments map(ResponseReader reader, @Nonnull String conditionalType) {
          AntennaFields antennaFields = null;
          if (AntennaFields.POSSIBLE_TYPES.contains(conditionalType)) {
            antennaFields = antennaFieldsFieldMapper.map(reader);
          }
          return new Fragments(antennaFields);
        }
      }
    }

    public static final class Mapper implements ResponseFieldMapper<NearestAntennaFromOrange1> {
      final Coordinates4.Mapper coordinates4FieldMapper = new Coordinates4.Mapper();

      final Fragments.Mapper fragmentsFieldMapper = new Fragments.Mapper();

      @Override
      public NearestAntennaFromOrange1 map(ResponseReader reader) {
        final String __typename = reader.readString($responseFields[0]);
        final Coordinates4 coordinates = reader.readObject($responseFields[1], new ResponseReader.ObjectReader<Coordinates4>() {
          @Override
          public Coordinates4 read(ResponseReader reader) {
            return coordinates4FieldMapper.map(reader);
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
        final Fragments fragments = reader.readConditional((ResponseField.ConditionalTypeField) $responseFields[10], new ResponseReader.ConditionalTypeReader<Fragments>() {
          @Override
          public Fragments read(String conditionalType, ResponseReader reader) {
            return fragmentsFieldMapper.map(reader, conditionalType);
          }
        });
        return new NearestAntennaFromOrange1(__typename, coordinates, generation, provider, lastUpdate, status, dist, insee, city, addressLabel, fragments);
      }
    }
  }

  public static class Coordinates4 {
    static final ResponseField[] $responseFields = {
      ResponseField.forDouble("latitude", "latitude", null, true),
      ResponseField.forDouble("longitude", "longitude", null, true)
    };

    final @Nullable Double latitude;

    final @Nullable Double longitude;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public Coordinates4(@Nullable Double latitude, @Nullable Double longitude) {
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
        $toString = "Coordinates4{"
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
      if (o instanceof Coordinates4) {
        Coordinates4 that = (Coordinates4) o;
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

    public static final class Mapper implements ResponseFieldMapper<Coordinates4> {
      @Override
      public Coordinates4 map(ResponseReader reader) {
        final Double latitude = reader.readDouble($responseFields[0]);
        final Double longitude = reader.readDouble($responseFields[1]);
        return new Coordinates4(latitude, longitude);
      }
    }
  }

  public static class NearestAntennaFromBouygues1 {
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
      ResponseField.forString("addressLabel", "addressLabel", null, true),
      ResponseField.forFragment("__typename", "__typename", Arrays.asList("NearestAntenna"))
    };

    final @Nonnull String __typename;

    final @Nullable Coordinates5 coordinates;

    final @Nullable String generation;

    final @Nullable String provider;

    final @Nullable String lastUpdate;

    final @Nullable String status;

    final @Nullable Integer dist;

    final @Nullable String insee;

    final @Nullable String city;

    final @Nullable String addressLabel;

    private final @Nonnull Fragments fragments;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public NearestAntennaFromBouygues1(@Nonnull String __typename,
        @Nullable Coordinates5 coordinates, @Nullable String generation, @Nullable String provider,
        @Nullable String lastUpdate, @Nullable String status, @Nullable Integer dist,
        @Nullable String insee, @Nullable String city, @Nullable String addressLabel,
        @Nonnull Fragments fragments) {
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
      if (fragments == null) {
        throw new NullPointerException("fragments can't be null");
      }
      this.fragments = fragments;
    }

    public @Nonnull String __typename() {
      return this.__typename;
    }

    public @Nullable Coordinates5 coordinates() {
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

    public @Nonnull Fragments fragments() {
      return this.fragments;
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
          fragments.marshaller().marshal(writer);
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "NearestAntennaFromBouygues1{"
          + "__typename=" + __typename + ", "
          + "coordinates=" + coordinates + ", "
          + "generation=" + generation + ", "
          + "provider=" + provider + ", "
          + "lastUpdate=" + lastUpdate + ", "
          + "status=" + status + ", "
          + "dist=" + dist + ", "
          + "insee=" + insee + ", "
          + "city=" + city + ", "
          + "addressLabel=" + addressLabel + ", "
          + "fragments=" + fragments
          + "}";
      }
      return $toString;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (o instanceof NearestAntennaFromBouygues1) {
        NearestAntennaFromBouygues1 that = (NearestAntennaFromBouygues1) o;
        return this.__typename.equals(that.__typename)
         && ((this.coordinates == null) ? (that.coordinates == null) : this.coordinates.equals(that.coordinates))
         && ((this.generation == null) ? (that.generation == null) : this.generation.equals(that.generation))
         && ((this.provider == null) ? (that.provider == null) : this.provider.equals(that.provider))
         && ((this.lastUpdate == null) ? (that.lastUpdate == null) : this.lastUpdate.equals(that.lastUpdate))
         && ((this.status == null) ? (that.status == null) : this.status.equals(that.status))
         && ((this.dist == null) ? (that.dist == null) : this.dist.equals(that.dist))
         && ((this.insee == null) ? (that.insee == null) : this.insee.equals(that.insee))
         && ((this.city == null) ? (that.city == null) : this.city.equals(that.city))
         && ((this.addressLabel == null) ? (that.addressLabel == null) : this.addressLabel.equals(that.addressLabel))
         && this.fragments.equals(that.fragments);
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
        h *= 1000003;
        h ^= fragments.hashCode();
        $hashCode = h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    public static class Fragments {
      final @Nonnull AntennaFields antennaFields;

      private volatile String $toString;

      private volatile int $hashCode;

      private volatile boolean $hashCodeMemoized;

      public Fragments(@Nonnull AntennaFields antennaFields) {
        if (antennaFields == null) {
          throw new NullPointerException("antennaFields can't be null");
        }
        this.antennaFields = antennaFields;
      }

      public @Nonnull AntennaFields antennaFields() {
        return this.antennaFields;
      }

      public ResponseFieldMarshaller marshaller() {
        return new ResponseFieldMarshaller() {
          @Override
          public void marshal(ResponseWriter writer) {
            final AntennaFields $antennaFields = antennaFields;
            if ($antennaFields != null) {
              $antennaFields.marshaller().marshal(writer);
            }
          }
        };
      }

      @Override
      public String toString() {
        if ($toString == null) {
          $toString = "Fragments{"
            + "antennaFields=" + antennaFields
            + "}";
        }
        return $toString;
      }

      @Override
      public boolean equals(Object o) {
        if (o == this) {
          return true;
        }
        if (o instanceof Fragments) {
          Fragments that = (Fragments) o;
          return this.antennaFields.equals(that.antennaFields);
        }
        return false;
      }

      @Override
      public int hashCode() {
        if (!$hashCodeMemoized) {
          int h = 1;
          h *= 1000003;
          h ^= antennaFields.hashCode();
          $hashCode = h;
          $hashCodeMemoized = true;
        }
        return $hashCode;
      }

      public static final class Mapper implements FragmentResponseFieldMapper<Fragments> {
        final AntennaFields.Mapper antennaFieldsFieldMapper = new AntennaFields.Mapper();

        @Override
        public @Nonnull Fragments map(ResponseReader reader, @Nonnull String conditionalType) {
          AntennaFields antennaFields = null;
          if (AntennaFields.POSSIBLE_TYPES.contains(conditionalType)) {
            antennaFields = antennaFieldsFieldMapper.map(reader);
          }
          return new Fragments(antennaFields);
        }
      }
    }

    public static final class Mapper implements ResponseFieldMapper<NearestAntennaFromBouygues1> {
      final Coordinates5.Mapper coordinates5FieldMapper = new Coordinates5.Mapper();

      final Fragments.Mapper fragmentsFieldMapper = new Fragments.Mapper();

      @Override
      public NearestAntennaFromBouygues1 map(ResponseReader reader) {
        final String __typename = reader.readString($responseFields[0]);
        final Coordinates5 coordinates = reader.readObject($responseFields[1], new ResponseReader.ObjectReader<Coordinates5>() {
          @Override
          public Coordinates5 read(ResponseReader reader) {
            return coordinates5FieldMapper.map(reader);
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
        final Fragments fragments = reader.readConditional((ResponseField.ConditionalTypeField) $responseFields[10], new ResponseReader.ConditionalTypeReader<Fragments>() {
          @Override
          public Fragments read(String conditionalType, ResponseReader reader) {
            return fragmentsFieldMapper.map(reader, conditionalType);
          }
        });
        return new NearestAntennaFromBouygues1(__typename, coordinates, generation, provider, lastUpdate, status, dist, insee, city, addressLabel, fragments);
      }
    }
  }

  public static class Coordinates5 {
    static final ResponseField[] $responseFields = {
      ResponseField.forDouble("latitude", "latitude", null, true),
      ResponseField.forDouble("longitude", "longitude", null, true)
    };

    final @Nullable Double latitude;

    final @Nullable Double longitude;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public Coordinates5(@Nullable Double latitude, @Nullable Double longitude) {
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
        $toString = "Coordinates5{"
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
      if (o instanceof Coordinates5) {
        Coordinates5 that = (Coordinates5) o;
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

    public static final class Mapper implements ResponseFieldMapper<Coordinates5> {
      @Override
      public Coordinates5 map(ResponseReader reader) {
        final Double latitude = reader.readDouble($responseFields[0]);
        final Double longitude = reader.readDouble($responseFields[1]);
        return new Coordinates5(latitude, longitude);
      }
    }
  }

  public static class NearestAntennaFromSfr1 {
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
      ResponseField.forString("addressLabel", "addressLabel", null, true),
      ResponseField.forFragment("__typename", "__typename", Arrays.asList("NearestAntenna"))
    };

    final @Nonnull String __typename;

    final @Nullable Coordinates6 coordinates;

    final @Nullable String generation;

    final @Nullable String provider;

    final @Nullable String lastUpdate;

    final @Nullable String status;

    final @Nullable Integer dist;

    final @Nullable String insee;

    final @Nullable String city;

    final @Nullable String addressLabel;

    private final @Nonnull Fragments fragments;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public NearestAntennaFromSfr1(@Nonnull String __typename, @Nullable Coordinates6 coordinates,
        @Nullable String generation, @Nullable String provider, @Nullable String lastUpdate,
        @Nullable String status, @Nullable Integer dist, @Nullable String insee,
        @Nullable String city, @Nullable String addressLabel, @Nonnull Fragments fragments) {
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
      if (fragments == null) {
        throw new NullPointerException("fragments can't be null");
      }
      this.fragments = fragments;
    }

    public @Nonnull String __typename() {
      return this.__typename;
    }

    public @Nullable Coordinates6 coordinates() {
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

    public @Nonnull Fragments fragments() {
      return this.fragments;
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
          fragments.marshaller().marshal(writer);
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "NearestAntennaFromSfr1{"
          + "__typename=" + __typename + ", "
          + "coordinates=" + coordinates + ", "
          + "generation=" + generation + ", "
          + "provider=" + provider + ", "
          + "lastUpdate=" + lastUpdate + ", "
          + "status=" + status + ", "
          + "dist=" + dist + ", "
          + "insee=" + insee + ", "
          + "city=" + city + ", "
          + "addressLabel=" + addressLabel + ", "
          + "fragments=" + fragments
          + "}";
      }
      return $toString;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (o instanceof NearestAntennaFromSfr1) {
        NearestAntennaFromSfr1 that = (NearestAntennaFromSfr1) o;
        return this.__typename.equals(that.__typename)
         && ((this.coordinates == null) ? (that.coordinates == null) : this.coordinates.equals(that.coordinates))
         && ((this.generation == null) ? (that.generation == null) : this.generation.equals(that.generation))
         && ((this.provider == null) ? (that.provider == null) : this.provider.equals(that.provider))
         && ((this.lastUpdate == null) ? (that.lastUpdate == null) : this.lastUpdate.equals(that.lastUpdate))
         && ((this.status == null) ? (that.status == null) : this.status.equals(that.status))
         && ((this.dist == null) ? (that.dist == null) : this.dist.equals(that.dist))
         && ((this.insee == null) ? (that.insee == null) : this.insee.equals(that.insee))
         && ((this.city == null) ? (that.city == null) : this.city.equals(that.city))
         && ((this.addressLabel == null) ? (that.addressLabel == null) : this.addressLabel.equals(that.addressLabel))
         && this.fragments.equals(that.fragments);
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
        h *= 1000003;
        h ^= fragments.hashCode();
        $hashCode = h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    public static class Fragments {
      final @Nonnull AntennaFields antennaFields;

      private volatile String $toString;

      private volatile int $hashCode;

      private volatile boolean $hashCodeMemoized;

      public Fragments(@Nonnull AntennaFields antennaFields) {
        if (antennaFields == null) {
          throw new NullPointerException("antennaFields can't be null");
        }
        this.antennaFields = antennaFields;
      }

      public @Nonnull AntennaFields antennaFields() {
        return this.antennaFields;
      }

      public ResponseFieldMarshaller marshaller() {
        return new ResponseFieldMarshaller() {
          @Override
          public void marshal(ResponseWriter writer) {
            final AntennaFields $antennaFields = antennaFields;
            if ($antennaFields != null) {
              $antennaFields.marshaller().marshal(writer);
            }
          }
        };
      }

      @Override
      public String toString() {
        if ($toString == null) {
          $toString = "Fragments{"
            + "antennaFields=" + antennaFields
            + "}";
        }
        return $toString;
      }

      @Override
      public boolean equals(Object o) {
        if (o == this) {
          return true;
        }
        if (o instanceof Fragments) {
          Fragments that = (Fragments) o;
          return this.antennaFields.equals(that.antennaFields);
        }
        return false;
      }

      @Override
      public int hashCode() {
        if (!$hashCodeMemoized) {
          int h = 1;
          h *= 1000003;
          h ^= antennaFields.hashCode();
          $hashCode = h;
          $hashCodeMemoized = true;
        }
        return $hashCode;
      }

      public static final class Mapper implements FragmentResponseFieldMapper<Fragments> {
        final AntennaFields.Mapper antennaFieldsFieldMapper = new AntennaFields.Mapper();

        @Override
        public @Nonnull Fragments map(ResponseReader reader, @Nonnull String conditionalType) {
          AntennaFields antennaFields = null;
          if (AntennaFields.POSSIBLE_TYPES.contains(conditionalType)) {
            antennaFields = antennaFieldsFieldMapper.map(reader);
          }
          return new Fragments(antennaFields);
        }
      }
    }

    public static final class Mapper implements ResponseFieldMapper<NearestAntennaFromSfr1> {
      final Coordinates6.Mapper coordinates6FieldMapper = new Coordinates6.Mapper();

      final Fragments.Mapper fragmentsFieldMapper = new Fragments.Mapper();

      @Override
      public NearestAntennaFromSfr1 map(ResponseReader reader) {
        final String __typename = reader.readString($responseFields[0]);
        final Coordinates6 coordinates = reader.readObject($responseFields[1], new ResponseReader.ObjectReader<Coordinates6>() {
          @Override
          public Coordinates6 read(ResponseReader reader) {
            return coordinates6FieldMapper.map(reader);
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
        final Fragments fragments = reader.readConditional((ResponseField.ConditionalTypeField) $responseFields[10], new ResponseReader.ConditionalTypeReader<Fragments>() {
          @Override
          public Fragments read(String conditionalType, ResponseReader reader) {
            return fragmentsFieldMapper.map(reader, conditionalType);
          }
        });
        return new NearestAntennaFromSfr1(__typename, coordinates, generation, provider, lastUpdate, status, dist, insee, city, addressLabel, fragments);
      }
    }
  }

  public static class Coordinates6 {
    static final ResponseField[] $responseFields = {
      ResponseField.forDouble("latitude", "latitude", null, true),
      ResponseField.forDouble("longitude", "longitude", null, true)
    };

    final @Nullable Double latitude;

    final @Nullable Double longitude;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public Coordinates6(@Nullable Double latitude, @Nullable Double longitude) {
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
        $toString = "Coordinates6{"
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
      if (o instanceof Coordinates6) {
        Coordinates6 that = (Coordinates6) o;
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

    public static final class Mapper implements ResponseFieldMapper<Coordinates6> {
      @Override
      public Coordinates6 map(ResponseReader reader) {
        final Double latitude = reader.readDouble($responseFields[0]);
        final Double longitude = reader.readDouble($responseFields[1]);
        return new Coordinates6(latitude, longitude);
      }
    }
  }

  public static class NearestAntennaFromFree1 {
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
      ResponseField.forString("addressLabel", "addressLabel", null, true),
      ResponseField.forFragment("__typename", "__typename", Arrays.asList("NearestAntenna"))
    };

    final @Nonnull String __typename;

    final @Nullable Coordinates7 coordinates;

    final @Nullable String generation;

    final @Nullable String provider;

    final @Nullable String lastUpdate;

    final @Nullable String status;

    final @Nullable Integer dist;

    final @Nullable String insee;

    final @Nullable String city;

    final @Nullable String addressLabel;

    private final @Nonnull Fragments fragments;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public NearestAntennaFromFree1(@Nonnull String __typename, @Nullable Coordinates7 coordinates,
        @Nullable String generation, @Nullable String provider, @Nullable String lastUpdate,
        @Nullable String status, @Nullable Integer dist, @Nullable String insee,
        @Nullable String city, @Nullable String addressLabel, @Nonnull Fragments fragments) {
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
      if (fragments == null) {
        throw new NullPointerException("fragments can't be null");
      }
      this.fragments = fragments;
    }

    public @Nonnull String __typename() {
      return this.__typename;
    }

    public @Nullable Coordinates7 coordinates() {
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

    public @Nonnull Fragments fragments() {
      return this.fragments;
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
          fragments.marshaller().marshal(writer);
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "NearestAntennaFromFree1{"
          + "__typename=" + __typename + ", "
          + "coordinates=" + coordinates + ", "
          + "generation=" + generation + ", "
          + "provider=" + provider + ", "
          + "lastUpdate=" + lastUpdate + ", "
          + "status=" + status + ", "
          + "dist=" + dist + ", "
          + "insee=" + insee + ", "
          + "city=" + city + ", "
          + "addressLabel=" + addressLabel + ", "
          + "fragments=" + fragments
          + "}";
      }
      return $toString;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (o instanceof NearestAntennaFromFree1) {
        NearestAntennaFromFree1 that = (NearestAntennaFromFree1) o;
        return this.__typename.equals(that.__typename)
         && ((this.coordinates == null) ? (that.coordinates == null) : this.coordinates.equals(that.coordinates))
         && ((this.generation == null) ? (that.generation == null) : this.generation.equals(that.generation))
         && ((this.provider == null) ? (that.provider == null) : this.provider.equals(that.provider))
         && ((this.lastUpdate == null) ? (that.lastUpdate == null) : this.lastUpdate.equals(that.lastUpdate))
         && ((this.status == null) ? (that.status == null) : this.status.equals(that.status))
         && ((this.dist == null) ? (that.dist == null) : this.dist.equals(that.dist))
         && ((this.insee == null) ? (that.insee == null) : this.insee.equals(that.insee))
         && ((this.city == null) ? (that.city == null) : this.city.equals(that.city))
         && ((this.addressLabel == null) ? (that.addressLabel == null) : this.addressLabel.equals(that.addressLabel))
         && this.fragments.equals(that.fragments);
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
        h *= 1000003;
        h ^= fragments.hashCode();
        $hashCode = h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    public static class Fragments {
      final @Nonnull AntennaFields antennaFields;

      private volatile String $toString;

      private volatile int $hashCode;

      private volatile boolean $hashCodeMemoized;

      public Fragments(@Nonnull AntennaFields antennaFields) {
        if (antennaFields == null) {
          throw new NullPointerException("antennaFields can't be null");
        }
        this.antennaFields = antennaFields;
      }

      public @Nonnull AntennaFields antennaFields() {
        return this.antennaFields;
      }

      public ResponseFieldMarshaller marshaller() {
        return new ResponseFieldMarshaller() {
          @Override
          public void marshal(ResponseWriter writer) {
            final AntennaFields $antennaFields = antennaFields;
            if ($antennaFields != null) {
              $antennaFields.marshaller().marshal(writer);
            }
          }
        };
      }

      @Override
      public String toString() {
        if ($toString == null) {
          $toString = "Fragments{"
            + "antennaFields=" + antennaFields
            + "}";
        }
        return $toString;
      }

      @Override
      public boolean equals(Object o) {
        if (o == this) {
          return true;
        }
        if (o instanceof Fragments) {
          Fragments that = (Fragments) o;
          return this.antennaFields.equals(that.antennaFields);
        }
        return false;
      }

      @Override
      public int hashCode() {
        if (!$hashCodeMemoized) {
          int h = 1;
          h *= 1000003;
          h ^= antennaFields.hashCode();
          $hashCode = h;
          $hashCodeMemoized = true;
        }
        return $hashCode;
      }

      public static final class Mapper implements FragmentResponseFieldMapper<Fragments> {
        final AntennaFields.Mapper antennaFieldsFieldMapper = new AntennaFields.Mapper();

        @Override
        public @Nonnull Fragments map(ResponseReader reader, @Nonnull String conditionalType) {
          AntennaFields antennaFields = null;
          if (AntennaFields.POSSIBLE_TYPES.contains(conditionalType)) {
            antennaFields = antennaFieldsFieldMapper.map(reader);
          }
          return new Fragments(antennaFields);
        }
      }
    }

    public static final class Mapper implements ResponseFieldMapper<NearestAntennaFromFree1> {
      final Coordinates7.Mapper coordinates7FieldMapper = new Coordinates7.Mapper();

      final Fragments.Mapper fragmentsFieldMapper = new Fragments.Mapper();

      @Override
      public NearestAntennaFromFree1 map(ResponseReader reader) {
        final String __typename = reader.readString($responseFields[0]);
        final Coordinates7 coordinates = reader.readObject($responseFields[1], new ResponseReader.ObjectReader<Coordinates7>() {
          @Override
          public Coordinates7 read(ResponseReader reader) {
            return coordinates7FieldMapper.map(reader);
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
        final Fragments fragments = reader.readConditional((ResponseField.ConditionalTypeField) $responseFields[10], new ResponseReader.ConditionalTypeReader<Fragments>() {
          @Override
          public Fragments read(String conditionalType, ResponseReader reader) {
            return fragmentsFieldMapper.map(reader, conditionalType);
          }
        });
        return new NearestAntennaFromFree1(__typename, coordinates, generation, provider, lastUpdate, status, dist, insee, city, addressLabel, fragments);
      }
    }
  }

  public static class Coordinates7 {
    static final ResponseField[] $responseFields = {
      ResponseField.forDouble("latitude", "latitude", null, true),
      ResponseField.forDouble("longitude", "longitude", null, true)
    };

    final @Nullable Double latitude;

    final @Nullable Double longitude;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public Coordinates7(@Nullable Double latitude, @Nullable Double longitude) {
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
        $toString = "Coordinates7{"
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
      if (o instanceof Coordinates7) {
        Coordinates7 that = (Coordinates7) o;
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

    public static final class Mapper implements ResponseFieldMapper<Coordinates7> {
      @Override
      public Coordinates7 map(ResponseReader reader) {
        final Double latitude = reader.readDouble($responseFields[0]);
        final Double longitude = reader.readDouble($responseFields[1]);
        return new Coordinates7(latitude, longitude);
      }
    }
  }

  public static class AsCity {
    static final ResponseField[] $responseFields = {
      ResponseField.forString("__typename", "__typename", null, false),
      ResponseField.forString("city", "city", null, true),
      ResponseField.forString("zipCode", "zipCode", null, true),
      ResponseField.forObject("nearestAntennaFromOrange", "nearestAntenna", new UnmodifiableMapBuilder<String, Object>(1)
        .put("provider", "ORANGE")
      .build(), true),
      ResponseField.forObject("nearestAntennaFromBouygues", "nearestAntenna", new UnmodifiableMapBuilder<String, Object>(1)
        .put("provider", "BOUYGUES_TELECOM")
      .build(), true),
      ResponseField.forObject("nearestAntennaFromSfr", "nearestAntenna", new UnmodifiableMapBuilder<String, Object>(1)
        .put("provider", "SFR")
      .build(), true),
      ResponseField.forObject("nearestAntennaFromFree", "nearestAntenna", new UnmodifiableMapBuilder<String, Object>(1)
        .put("provider", "FREE")
      .build(), true)
    };

    final @Nonnull String __typename;

    final @Nullable String city;

    final @Nullable String zipCode;

    final @Nullable NearestAntennaFromOrange2 nearestAntennaFromOrange;

    final @Nullable NearestAntennaFromBouygues2 nearestAntennaFromBouygues;

    final @Nullable NearestAntennaFromSfr2 nearestAntennaFromSfr;

    final @Nullable NearestAntennaFromFree2 nearestAntennaFromFree;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public AsCity(@Nonnull String __typename, @Nullable String city, @Nullable String zipCode,
        @Nullable NearestAntennaFromOrange2 nearestAntennaFromOrange,
        @Nullable NearestAntennaFromBouygues2 nearestAntennaFromBouygues,
        @Nullable NearestAntennaFromSfr2 nearestAntennaFromSfr,
        @Nullable NearestAntennaFromFree2 nearestAntennaFromFree) {
      if (__typename == null) {
        throw new NullPointerException("__typename can't be null");
      }
      this.__typename = __typename;
      this.city = city;
      this.zipCode = zipCode;
      this.nearestAntennaFromOrange = nearestAntennaFromOrange;
      this.nearestAntennaFromBouygues = nearestAntennaFromBouygues;
      this.nearestAntennaFromSfr = nearestAntennaFromSfr;
      this.nearestAntennaFromFree = nearestAntennaFromFree;
    }

    public @Nonnull String __typename() {
      return this.__typename;
    }

    public @Nullable String city() {
      return this.city;
    }

    public @Nullable String zipCode() {
      return this.zipCode;
    }

    public @Nullable NearestAntennaFromOrange2 nearestAntennaFromOrange() {
      return this.nearestAntennaFromOrange;
    }

    public @Nullable NearestAntennaFromBouygues2 nearestAntennaFromBouygues() {
      return this.nearestAntennaFromBouygues;
    }

    public @Nullable NearestAntennaFromSfr2 nearestAntennaFromSfr() {
      return this.nearestAntennaFromSfr;
    }

    public @Nullable NearestAntennaFromFree2 nearestAntennaFromFree() {
      return this.nearestAntennaFromFree;
    }

    public ResponseFieldMarshaller marshaller() {
      return new ResponseFieldMarshaller() {
        @Override
        public void marshal(ResponseWriter writer) {
          writer.writeString($responseFields[0], __typename);
          writer.writeString($responseFields[1], city);
          writer.writeString($responseFields[2], zipCode);
          writer.writeObject($responseFields[3], nearestAntennaFromOrange != null ? nearestAntennaFromOrange.marshaller() : null);
          writer.writeObject($responseFields[4], nearestAntennaFromBouygues != null ? nearestAntennaFromBouygues.marshaller() : null);
          writer.writeObject($responseFields[5], nearestAntennaFromSfr != null ? nearestAntennaFromSfr.marshaller() : null);
          writer.writeObject($responseFields[6], nearestAntennaFromFree != null ? nearestAntennaFromFree.marshaller() : null);
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "AsCity{"
          + "__typename=" + __typename + ", "
          + "city=" + city + ", "
          + "zipCode=" + zipCode + ", "
          + "nearestAntennaFromOrange=" + nearestAntennaFromOrange + ", "
          + "nearestAntennaFromBouygues=" + nearestAntennaFromBouygues + ", "
          + "nearestAntennaFromSfr=" + nearestAntennaFromSfr + ", "
          + "nearestAntennaFromFree=" + nearestAntennaFromFree
          + "}";
      }
      return $toString;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (o instanceof AsCity) {
        AsCity that = (AsCity) o;
        return this.__typename.equals(that.__typename)
         && ((this.city == null) ? (that.city == null) : this.city.equals(that.city))
         && ((this.zipCode == null) ? (that.zipCode == null) : this.zipCode.equals(that.zipCode))
         && ((this.nearestAntennaFromOrange == null) ? (that.nearestAntennaFromOrange == null) : this.nearestAntennaFromOrange.equals(that.nearestAntennaFromOrange))
         && ((this.nearestAntennaFromBouygues == null) ? (that.nearestAntennaFromBouygues == null) : this.nearestAntennaFromBouygues.equals(that.nearestAntennaFromBouygues))
         && ((this.nearestAntennaFromSfr == null) ? (that.nearestAntennaFromSfr == null) : this.nearestAntennaFromSfr.equals(that.nearestAntennaFromSfr))
         && ((this.nearestAntennaFromFree == null) ? (that.nearestAntennaFromFree == null) : this.nearestAntennaFromFree.equals(that.nearestAntennaFromFree));
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
        h ^= (city == null) ? 0 : city.hashCode();
        h *= 1000003;
        h ^= (zipCode == null) ? 0 : zipCode.hashCode();
        h *= 1000003;
        h ^= (nearestAntennaFromOrange == null) ? 0 : nearestAntennaFromOrange.hashCode();
        h *= 1000003;
        h ^= (nearestAntennaFromBouygues == null) ? 0 : nearestAntennaFromBouygues.hashCode();
        h *= 1000003;
        h ^= (nearestAntennaFromSfr == null) ? 0 : nearestAntennaFromSfr.hashCode();
        h *= 1000003;
        h ^= (nearestAntennaFromFree == null) ? 0 : nearestAntennaFromFree.hashCode();
        $hashCode = h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    public static final class Mapper implements ResponseFieldMapper<AsCity> {
      final NearestAntennaFromOrange2.Mapper nearestAntennaFromOrange2FieldMapper = new NearestAntennaFromOrange2.Mapper();

      final NearestAntennaFromBouygues2.Mapper nearestAntennaFromBouygues2FieldMapper = new NearestAntennaFromBouygues2.Mapper();

      final NearestAntennaFromSfr2.Mapper nearestAntennaFromSfr2FieldMapper = new NearestAntennaFromSfr2.Mapper();

      final NearestAntennaFromFree2.Mapper nearestAntennaFromFree2FieldMapper = new NearestAntennaFromFree2.Mapper();

      @Override
      public AsCity map(ResponseReader reader) {
        final String __typename = reader.readString($responseFields[0]);
        final String city = reader.readString($responseFields[1]);
        final String zipCode = reader.readString($responseFields[2]);
        final NearestAntennaFromOrange2 nearestAntennaFromOrange = reader.readObject($responseFields[3], new ResponseReader.ObjectReader<NearestAntennaFromOrange2>() {
          @Override
          public NearestAntennaFromOrange2 read(ResponseReader reader) {
            return nearestAntennaFromOrange2FieldMapper.map(reader);
          }
        });
        final NearestAntennaFromBouygues2 nearestAntennaFromBouygues = reader.readObject($responseFields[4], new ResponseReader.ObjectReader<NearestAntennaFromBouygues2>() {
          @Override
          public NearestAntennaFromBouygues2 read(ResponseReader reader) {
            return nearestAntennaFromBouygues2FieldMapper.map(reader);
          }
        });
        final NearestAntennaFromSfr2 nearestAntennaFromSfr = reader.readObject($responseFields[5], new ResponseReader.ObjectReader<NearestAntennaFromSfr2>() {
          @Override
          public NearestAntennaFromSfr2 read(ResponseReader reader) {
            return nearestAntennaFromSfr2FieldMapper.map(reader);
          }
        });
        final NearestAntennaFromFree2 nearestAntennaFromFree = reader.readObject($responseFields[6], new ResponseReader.ObjectReader<NearestAntennaFromFree2>() {
          @Override
          public NearestAntennaFromFree2 read(ResponseReader reader) {
            return nearestAntennaFromFree2FieldMapper.map(reader);
          }
        });
        return new AsCity(__typename, city, zipCode, nearestAntennaFromOrange, nearestAntennaFromBouygues, nearestAntennaFromSfr, nearestAntennaFromFree);
      }
    }
  }

  public static class NearestAntennaFromOrange2 {
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
      ResponseField.forString("addressLabel", "addressLabel", null, true),
      ResponseField.forFragment("__typename", "__typename", Arrays.asList("NearestAntenna"))
    };

    final @Nonnull String __typename;

    final @Nullable Coordinates8 coordinates;

    final @Nullable String generation;

    final @Nullable String provider;

    final @Nullable String lastUpdate;

    final @Nullable String status;

    final @Nullable Integer dist;

    final @Nullable String insee;

    final @Nullable String city;

    final @Nullable String addressLabel;

    private final @Nonnull Fragments fragments;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public NearestAntennaFromOrange2(@Nonnull String __typename, @Nullable Coordinates8 coordinates,
        @Nullable String generation, @Nullable String provider, @Nullable String lastUpdate,
        @Nullable String status, @Nullable Integer dist, @Nullable String insee,
        @Nullable String city, @Nullable String addressLabel, @Nonnull Fragments fragments) {
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
      if (fragments == null) {
        throw new NullPointerException("fragments can't be null");
      }
      this.fragments = fragments;
    }

    public @Nonnull String __typename() {
      return this.__typename;
    }

    public @Nullable Coordinates8 coordinates() {
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

    public @Nonnull Fragments fragments() {
      return this.fragments;
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
          fragments.marshaller().marshal(writer);
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "NearestAntennaFromOrange2{"
          + "__typename=" + __typename + ", "
          + "coordinates=" + coordinates + ", "
          + "generation=" + generation + ", "
          + "provider=" + provider + ", "
          + "lastUpdate=" + lastUpdate + ", "
          + "status=" + status + ", "
          + "dist=" + dist + ", "
          + "insee=" + insee + ", "
          + "city=" + city + ", "
          + "addressLabel=" + addressLabel + ", "
          + "fragments=" + fragments
          + "}";
      }
      return $toString;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (o instanceof NearestAntennaFromOrange2) {
        NearestAntennaFromOrange2 that = (NearestAntennaFromOrange2) o;
        return this.__typename.equals(that.__typename)
         && ((this.coordinates == null) ? (that.coordinates == null) : this.coordinates.equals(that.coordinates))
         && ((this.generation == null) ? (that.generation == null) : this.generation.equals(that.generation))
         && ((this.provider == null) ? (that.provider == null) : this.provider.equals(that.provider))
         && ((this.lastUpdate == null) ? (that.lastUpdate == null) : this.lastUpdate.equals(that.lastUpdate))
         && ((this.status == null) ? (that.status == null) : this.status.equals(that.status))
         && ((this.dist == null) ? (that.dist == null) : this.dist.equals(that.dist))
         && ((this.insee == null) ? (that.insee == null) : this.insee.equals(that.insee))
         && ((this.city == null) ? (that.city == null) : this.city.equals(that.city))
         && ((this.addressLabel == null) ? (that.addressLabel == null) : this.addressLabel.equals(that.addressLabel))
         && this.fragments.equals(that.fragments);
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
        h *= 1000003;
        h ^= fragments.hashCode();
        $hashCode = h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    public static class Fragments {
      final @Nonnull AntennaFields antennaFields;

      private volatile String $toString;

      private volatile int $hashCode;

      private volatile boolean $hashCodeMemoized;

      public Fragments(@Nonnull AntennaFields antennaFields) {
        if (antennaFields == null) {
          throw new NullPointerException("antennaFields can't be null");
        }
        this.antennaFields = antennaFields;
      }

      public @Nonnull AntennaFields antennaFields() {
        return this.antennaFields;
      }

      public ResponseFieldMarshaller marshaller() {
        return new ResponseFieldMarshaller() {
          @Override
          public void marshal(ResponseWriter writer) {
            final AntennaFields $antennaFields = antennaFields;
            if ($antennaFields != null) {
              $antennaFields.marshaller().marshal(writer);
            }
          }
        };
      }

      @Override
      public String toString() {
        if ($toString == null) {
          $toString = "Fragments{"
            + "antennaFields=" + antennaFields
            + "}";
        }
        return $toString;
      }

      @Override
      public boolean equals(Object o) {
        if (o == this) {
          return true;
        }
        if (o instanceof Fragments) {
          Fragments that = (Fragments) o;
          return this.antennaFields.equals(that.antennaFields);
        }
        return false;
      }

      @Override
      public int hashCode() {
        if (!$hashCodeMemoized) {
          int h = 1;
          h *= 1000003;
          h ^= antennaFields.hashCode();
          $hashCode = h;
          $hashCodeMemoized = true;
        }
        return $hashCode;
      }

      public static final class Mapper implements FragmentResponseFieldMapper<Fragments> {
        final AntennaFields.Mapper antennaFieldsFieldMapper = new AntennaFields.Mapper();

        @Override
        public @Nonnull Fragments map(ResponseReader reader, @Nonnull String conditionalType) {
          AntennaFields antennaFields = null;
          if (AntennaFields.POSSIBLE_TYPES.contains(conditionalType)) {
            antennaFields = antennaFieldsFieldMapper.map(reader);
          }
          return new Fragments(antennaFields);
        }
      }
    }

    public static final class Mapper implements ResponseFieldMapper<NearestAntennaFromOrange2> {
      final Coordinates8.Mapper coordinates8FieldMapper = new Coordinates8.Mapper();

      final Fragments.Mapper fragmentsFieldMapper = new Fragments.Mapper();

      @Override
      public NearestAntennaFromOrange2 map(ResponseReader reader) {
        final String __typename = reader.readString($responseFields[0]);
        final Coordinates8 coordinates = reader.readObject($responseFields[1], new ResponseReader.ObjectReader<Coordinates8>() {
          @Override
          public Coordinates8 read(ResponseReader reader) {
            return coordinates8FieldMapper.map(reader);
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
        final Fragments fragments = reader.readConditional((ResponseField.ConditionalTypeField) $responseFields[10], new ResponseReader.ConditionalTypeReader<Fragments>() {
          @Override
          public Fragments read(String conditionalType, ResponseReader reader) {
            return fragmentsFieldMapper.map(reader, conditionalType);
          }
        });
        return new NearestAntennaFromOrange2(__typename, coordinates, generation, provider, lastUpdate, status, dist, insee, city, addressLabel, fragments);
      }
    }
  }

  public static class Coordinates8 {
    static final ResponseField[] $responseFields = {
      ResponseField.forDouble("latitude", "latitude", null, true),
      ResponseField.forDouble("longitude", "longitude", null, true)
    };

    final @Nullable Double latitude;

    final @Nullable Double longitude;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public Coordinates8(@Nullable Double latitude, @Nullable Double longitude) {
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
        $toString = "Coordinates8{"
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
      if (o instanceof Coordinates8) {
        Coordinates8 that = (Coordinates8) o;
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

    public static final class Mapper implements ResponseFieldMapper<Coordinates8> {
      @Override
      public Coordinates8 map(ResponseReader reader) {
        final Double latitude = reader.readDouble($responseFields[0]);
        final Double longitude = reader.readDouble($responseFields[1]);
        return new Coordinates8(latitude, longitude);
      }
    }
  }

  public static class NearestAntennaFromBouygues2 {
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
      ResponseField.forString("addressLabel", "addressLabel", null, true),
      ResponseField.forFragment("__typename", "__typename", Arrays.asList("NearestAntenna"))
    };

    final @Nonnull String __typename;

    final @Nullable Coordinates9 coordinates;

    final @Nullable String generation;

    final @Nullable String provider;

    final @Nullable String lastUpdate;

    final @Nullable String status;

    final @Nullable Integer dist;

    final @Nullable String insee;

    final @Nullable String city;

    final @Nullable String addressLabel;

    private final @Nonnull Fragments fragments;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public NearestAntennaFromBouygues2(@Nonnull String __typename,
        @Nullable Coordinates9 coordinates, @Nullable String generation, @Nullable String provider,
        @Nullable String lastUpdate, @Nullable String status, @Nullable Integer dist,
        @Nullable String insee, @Nullable String city, @Nullable String addressLabel,
        @Nonnull Fragments fragments) {
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
      if (fragments == null) {
        throw new NullPointerException("fragments can't be null");
      }
      this.fragments = fragments;
    }

    public @Nonnull String __typename() {
      return this.__typename;
    }

    public @Nullable Coordinates9 coordinates() {
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

    public @Nonnull Fragments fragments() {
      return this.fragments;
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
          fragments.marshaller().marshal(writer);
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "NearestAntennaFromBouygues2{"
          + "__typename=" + __typename + ", "
          + "coordinates=" + coordinates + ", "
          + "generation=" + generation + ", "
          + "provider=" + provider + ", "
          + "lastUpdate=" + lastUpdate + ", "
          + "status=" + status + ", "
          + "dist=" + dist + ", "
          + "insee=" + insee + ", "
          + "city=" + city + ", "
          + "addressLabel=" + addressLabel + ", "
          + "fragments=" + fragments
          + "}";
      }
      return $toString;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (o instanceof NearestAntennaFromBouygues2) {
        NearestAntennaFromBouygues2 that = (NearestAntennaFromBouygues2) o;
        return this.__typename.equals(that.__typename)
         && ((this.coordinates == null) ? (that.coordinates == null) : this.coordinates.equals(that.coordinates))
         && ((this.generation == null) ? (that.generation == null) : this.generation.equals(that.generation))
         && ((this.provider == null) ? (that.provider == null) : this.provider.equals(that.provider))
         && ((this.lastUpdate == null) ? (that.lastUpdate == null) : this.lastUpdate.equals(that.lastUpdate))
         && ((this.status == null) ? (that.status == null) : this.status.equals(that.status))
         && ((this.dist == null) ? (that.dist == null) : this.dist.equals(that.dist))
         && ((this.insee == null) ? (that.insee == null) : this.insee.equals(that.insee))
         && ((this.city == null) ? (that.city == null) : this.city.equals(that.city))
         && ((this.addressLabel == null) ? (that.addressLabel == null) : this.addressLabel.equals(that.addressLabel))
         && this.fragments.equals(that.fragments);
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
        h *= 1000003;
        h ^= fragments.hashCode();
        $hashCode = h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    public static class Fragments {
      final @Nonnull AntennaFields antennaFields;

      private volatile String $toString;

      private volatile int $hashCode;

      private volatile boolean $hashCodeMemoized;

      public Fragments(@Nonnull AntennaFields antennaFields) {
        if (antennaFields == null) {
          throw new NullPointerException("antennaFields can't be null");
        }
        this.antennaFields = antennaFields;
      }

      public @Nonnull AntennaFields antennaFields() {
        return this.antennaFields;
      }

      public ResponseFieldMarshaller marshaller() {
        return new ResponseFieldMarshaller() {
          @Override
          public void marshal(ResponseWriter writer) {
            final AntennaFields $antennaFields = antennaFields;
            if ($antennaFields != null) {
              $antennaFields.marshaller().marshal(writer);
            }
          }
        };
      }

      @Override
      public String toString() {
        if ($toString == null) {
          $toString = "Fragments{"
            + "antennaFields=" + antennaFields
            + "}";
        }
        return $toString;
      }

      @Override
      public boolean equals(Object o) {
        if (o == this) {
          return true;
        }
        if (o instanceof Fragments) {
          Fragments that = (Fragments) o;
          return this.antennaFields.equals(that.antennaFields);
        }
        return false;
      }

      @Override
      public int hashCode() {
        if (!$hashCodeMemoized) {
          int h = 1;
          h *= 1000003;
          h ^= antennaFields.hashCode();
          $hashCode = h;
          $hashCodeMemoized = true;
        }
        return $hashCode;
      }

      public static final class Mapper implements FragmentResponseFieldMapper<Fragments> {
        final AntennaFields.Mapper antennaFieldsFieldMapper = new AntennaFields.Mapper();

        @Override
        public @Nonnull Fragments map(ResponseReader reader, @Nonnull String conditionalType) {
          AntennaFields antennaFields = null;
          if (AntennaFields.POSSIBLE_TYPES.contains(conditionalType)) {
            antennaFields = antennaFieldsFieldMapper.map(reader);
          }
          return new Fragments(antennaFields);
        }
      }
    }

    public static final class Mapper implements ResponseFieldMapper<NearestAntennaFromBouygues2> {
      final Coordinates9.Mapper coordinates9FieldMapper = new Coordinates9.Mapper();

      final Fragments.Mapper fragmentsFieldMapper = new Fragments.Mapper();

      @Override
      public NearestAntennaFromBouygues2 map(ResponseReader reader) {
        final String __typename = reader.readString($responseFields[0]);
        final Coordinates9 coordinates = reader.readObject($responseFields[1], new ResponseReader.ObjectReader<Coordinates9>() {
          @Override
          public Coordinates9 read(ResponseReader reader) {
            return coordinates9FieldMapper.map(reader);
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
        final Fragments fragments = reader.readConditional((ResponseField.ConditionalTypeField) $responseFields[10], new ResponseReader.ConditionalTypeReader<Fragments>() {
          @Override
          public Fragments read(String conditionalType, ResponseReader reader) {
            return fragmentsFieldMapper.map(reader, conditionalType);
          }
        });
        return new NearestAntennaFromBouygues2(__typename, coordinates, generation, provider, lastUpdate, status, dist, insee, city, addressLabel, fragments);
      }
    }
  }

  public static class Coordinates9 {
    static final ResponseField[] $responseFields = {
      ResponseField.forDouble("latitude", "latitude", null, true),
      ResponseField.forDouble("longitude", "longitude", null, true)
    };

    final @Nullable Double latitude;

    final @Nullable Double longitude;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public Coordinates9(@Nullable Double latitude, @Nullable Double longitude) {
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
        $toString = "Coordinates9{"
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
      if (o instanceof Coordinates9) {
        Coordinates9 that = (Coordinates9) o;
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

    public static final class Mapper implements ResponseFieldMapper<Coordinates9> {
      @Override
      public Coordinates9 map(ResponseReader reader) {
        final Double latitude = reader.readDouble($responseFields[0]);
        final Double longitude = reader.readDouble($responseFields[1]);
        return new Coordinates9(latitude, longitude);
      }
    }
  }

  public static class NearestAntennaFromSfr2 {
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
      ResponseField.forString("addressLabel", "addressLabel", null, true),
      ResponseField.forFragment("__typename", "__typename", Arrays.asList("NearestAntenna"))
    };

    final @Nonnull String __typename;

    final @Nullable Coordinates10 coordinates;

    final @Nullable String generation;

    final @Nullable String provider;

    final @Nullable String lastUpdate;

    final @Nullable String status;

    final @Nullable Integer dist;

    final @Nullable String insee;

    final @Nullable String city;

    final @Nullable String addressLabel;

    private final @Nonnull Fragments fragments;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public NearestAntennaFromSfr2(@Nonnull String __typename, @Nullable Coordinates10 coordinates,
        @Nullable String generation, @Nullable String provider, @Nullable String lastUpdate,
        @Nullable String status, @Nullable Integer dist, @Nullable String insee,
        @Nullable String city, @Nullable String addressLabel, @Nonnull Fragments fragments) {
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
      if (fragments == null) {
        throw new NullPointerException("fragments can't be null");
      }
      this.fragments = fragments;
    }

    public @Nonnull String __typename() {
      return this.__typename;
    }

    public @Nullable Coordinates10 coordinates() {
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

    public @Nonnull Fragments fragments() {
      return this.fragments;
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
          fragments.marshaller().marshal(writer);
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "NearestAntennaFromSfr2{"
          + "__typename=" + __typename + ", "
          + "coordinates=" + coordinates + ", "
          + "generation=" + generation + ", "
          + "provider=" + provider + ", "
          + "lastUpdate=" + lastUpdate + ", "
          + "status=" + status + ", "
          + "dist=" + dist + ", "
          + "insee=" + insee + ", "
          + "city=" + city + ", "
          + "addressLabel=" + addressLabel + ", "
          + "fragments=" + fragments
          + "}";
      }
      return $toString;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (o instanceof NearestAntennaFromSfr2) {
        NearestAntennaFromSfr2 that = (NearestAntennaFromSfr2) o;
        return this.__typename.equals(that.__typename)
         && ((this.coordinates == null) ? (that.coordinates == null) : this.coordinates.equals(that.coordinates))
         && ((this.generation == null) ? (that.generation == null) : this.generation.equals(that.generation))
         && ((this.provider == null) ? (that.provider == null) : this.provider.equals(that.provider))
         && ((this.lastUpdate == null) ? (that.lastUpdate == null) : this.lastUpdate.equals(that.lastUpdate))
         && ((this.status == null) ? (that.status == null) : this.status.equals(that.status))
         && ((this.dist == null) ? (that.dist == null) : this.dist.equals(that.dist))
         && ((this.insee == null) ? (that.insee == null) : this.insee.equals(that.insee))
         && ((this.city == null) ? (that.city == null) : this.city.equals(that.city))
         && ((this.addressLabel == null) ? (that.addressLabel == null) : this.addressLabel.equals(that.addressLabel))
         && this.fragments.equals(that.fragments);
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
        h *= 1000003;
        h ^= fragments.hashCode();
        $hashCode = h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    public static class Fragments {
      final @Nonnull AntennaFields antennaFields;

      private volatile String $toString;

      private volatile int $hashCode;

      private volatile boolean $hashCodeMemoized;

      public Fragments(@Nonnull AntennaFields antennaFields) {
        if (antennaFields == null) {
          throw new NullPointerException("antennaFields can't be null");
        }
        this.antennaFields = antennaFields;
      }

      public @Nonnull AntennaFields antennaFields() {
        return this.antennaFields;
      }

      public ResponseFieldMarshaller marshaller() {
        return new ResponseFieldMarshaller() {
          @Override
          public void marshal(ResponseWriter writer) {
            final AntennaFields $antennaFields = antennaFields;
            if ($antennaFields != null) {
              $antennaFields.marshaller().marshal(writer);
            }
          }
        };
      }

      @Override
      public String toString() {
        if ($toString == null) {
          $toString = "Fragments{"
            + "antennaFields=" + antennaFields
            + "}";
        }
        return $toString;
      }

      @Override
      public boolean equals(Object o) {
        if (o == this) {
          return true;
        }
        if (o instanceof Fragments) {
          Fragments that = (Fragments) o;
          return this.antennaFields.equals(that.antennaFields);
        }
        return false;
      }

      @Override
      public int hashCode() {
        if (!$hashCodeMemoized) {
          int h = 1;
          h *= 1000003;
          h ^= antennaFields.hashCode();
          $hashCode = h;
          $hashCodeMemoized = true;
        }
        return $hashCode;
      }

      public static final class Mapper implements FragmentResponseFieldMapper<Fragments> {
        final AntennaFields.Mapper antennaFieldsFieldMapper = new AntennaFields.Mapper();

        @Override
        public @Nonnull Fragments map(ResponseReader reader, @Nonnull String conditionalType) {
          AntennaFields antennaFields = null;
          if (AntennaFields.POSSIBLE_TYPES.contains(conditionalType)) {
            antennaFields = antennaFieldsFieldMapper.map(reader);
          }
          return new Fragments(antennaFields);
        }
      }
    }

    public static final class Mapper implements ResponseFieldMapper<NearestAntennaFromSfr2> {
      final Coordinates10.Mapper coordinates10FieldMapper = new Coordinates10.Mapper();

      final Fragments.Mapper fragmentsFieldMapper = new Fragments.Mapper();

      @Override
      public NearestAntennaFromSfr2 map(ResponseReader reader) {
        final String __typename = reader.readString($responseFields[0]);
        final Coordinates10 coordinates = reader.readObject($responseFields[1], new ResponseReader.ObjectReader<Coordinates10>() {
          @Override
          public Coordinates10 read(ResponseReader reader) {
            return coordinates10FieldMapper.map(reader);
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
        final Fragments fragments = reader.readConditional((ResponseField.ConditionalTypeField) $responseFields[10], new ResponseReader.ConditionalTypeReader<Fragments>() {
          @Override
          public Fragments read(String conditionalType, ResponseReader reader) {
            return fragmentsFieldMapper.map(reader, conditionalType);
          }
        });
        return new NearestAntennaFromSfr2(__typename, coordinates, generation, provider, lastUpdate, status, dist, insee, city, addressLabel, fragments);
      }
    }
  }

  public static class Coordinates10 {
    static final ResponseField[] $responseFields = {
      ResponseField.forDouble("latitude", "latitude", null, true),
      ResponseField.forDouble("longitude", "longitude", null, true)
    };

    final @Nullable Double latitude;

    final @Nullable Double longitude;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public Coordinates10(@Nullable Double latitude, @Nullable Double longitude) {
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
        $toString = "Coordinates10{"
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
      if (o instanceof Coordinates10) {
        Coordinates10 that = (Coordinates10) o;
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

    public static final class Mapper implements ResponseFieldMapper<Coordinates10> {
      @Override
      public Coordinates10 map(ResponseReader reader) {
        final Double latitude = reader.readDouble($responseFields[0]);
        final Double longitude = reader.readDouble($responseFields[1]);
        return new Coordinates10(latitude, longitude);
      }
    }
  }

  public static class NearestAntennaFromFree2 {
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
      ResponseField.forString("addressLabel", "addressLabel", null, true),
      ResponseField.forFragment("__typename", "__typename", Arrays.asList("NearestAntenna"))
    };

    final @Nonnull String __typename;

    final @Nullable Coordinates11 coordinates;

    final @Nullable String generation;

    final @Nullable String provider;

    final @Nullable String lastUpdate;

    final @Nullable String status;

    final @Nullable Integer dist;

    final @Nullable String insee;

    final @Nullable String city;

    final @Nullable String addressLabel;

    private final @Nonnull Fragments fragments;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public NearestAntennaFromFree2(@Nonnull String __typename, @Nullable Coordinates11 coordinates,
        @Nullable String generation, @Nullable String provider, @Nullable String lastUpdate,
        @Nullable String status, @Nullable Integer dist, @Nullable String insee,
        @Nullable String city, @Nullable String addressLabel, @Nonnull Fragments fragments) {
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
      if (fragments == null) {
        throw new NullPointerException("fragments can't be null");
      }
      this.fragments = fragments;
    }

    public @Nonnull String __typename() {
      return this.__typename;
    }

    public @Nullable Coordinates11 coordinates() {
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

    public @Nonnull Fragments fragments() {
      return this.fragments;
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
          fragments.marshaller().marshal(writer);
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "NearestAntennaFromFree2{"
          + "__typename=" + __typename + ", "
          + "coordinates=" + coordinates + ", "
          + "generation=" + generation + ", "
          + "provider=" + provider + ", "
          + "lastUpdate=" + lastUpdate + ", "
          + "status=" + status + ", "
          + "dist=" + dist + ", "
          + "insee=" + insee + ", "
          + "city=" + city + ", "
          + "addressLabel=" + addressLabel + ", "
          + "fragments=" + fragments
          + "}";
      }
      return $toString;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (o instanceof NearestAntennaFromFree2) {
        NearestAntennaFromFree2 that = (NearestAntennaFromFree2) o;
        return this.__typename.equals(that.__typename)
         && ((this.coordinates == null) ? (that.coordinates == null) : this.coordinates.equals(that.coordinates))
         && ((this.generation == null) ? (that.generation == null) : this.generation.equals(that.generation))
         && ((this.provider == null) ? (that.provider == null) : this.provider.equals(that.provider))
         && ((this.lastUpdate == null) ? (that.lastUpdate == null) : this.lastUpdate.equals(that.lastUpdate))
         && ((this.status == null) ? (that.status == null) : this.status.equals(that.status))
         && ((this.dist == null) ? (that.dist == null) : this.dist.equals(that.dist))
         && ((this.insee == null) ? (that.insee == null) : this.insee.equals(that.insee))
         && ((this.city == null) ? (that.city == null) : this.city.equals(that.city))
         && ((this.addressLabel == null) ? (that.addressLabel == null) : this.addressLabel.equals(that.addressLabel))
         && this.fragments.equals(that.fragments);
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
        h *= 1000003;
        h ^= fragments.hashCode();
        $hashCode = h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    public static class Fragments {
      final @Nonnull AntennaFields antennaFields;

      private volatile String $toString;

      private volatile int $hashCode;

      private volatile boolean $hashCodeMemoized;

      public Fragments(@Nonnull AntennaFields antennaFields) {
        if (antennaFields == null) {
          throw new NullPointerException("antennaFields can't be null");
        }
        this.antennaFields = antennaFields;
      }

      public @Nonnull AntennaFields antennaFields() {
        return this.antennaFields;
      }

      public ResponseFieldMarshaller marshaller() {
        return new ResponseFieldMarshaller() {
          @Override
          public void marshal(ResponseWriter writer) {
            final AntennaFields $antennaFields = antennaFields;
            if ($antennaFields != null) {
              $antennaFields.marshaller().marshal(writer);
            }
          }
        };
      }

      @Override
      public String toString() {
        if ($toString == null) {
          $toString = "Fragments{"
            + "antennaFields=" + antennaFields
            + "}";
        }
        return $toString;
      }

      @Override
      public boolean equals(Object o) {
        if (o == this) {
          return true;
        }
        if (o instanceof Fragments) {
          Fragments that = (Fragments) o;
          return this.antennaFields.equals(that.antennaFields);
        }
        return false;
      }

      @Override
      public int hashCode() {
        if (!$hashCodeMemoized) {
          int h = 1;
          h *= 1000003;
          h ^= antennaFields.hashCode();
          $hashCode = h;
          $hashCodeMemoized = true;
        }
        return $hashCode;
      }

      public static final class Mapper implements FragmentResponseFieldMapper<Fragments> {
        final AntennaFields.Mapper antennaFieldsFieldMapper = new AntennaFields.Mapper();

        @Override
        public @Nonnull Fragments map(ResponseReader reader, @Nonnull String conditionalType) {
          AntennaFields antennaFields = null;
          if (AntennaFields.POSSIBLE_TYPES.contains(conditionalType)) {
            antennaFields = antennaFieldsFieldMapper.map(reader);
          }
          return new Fragments(antennaFields);
        }
      }
    }

    public static final class Mapper implements ResponseFieldMapper<NearestAntennaFromFree2> {
      final Coordinates11.Mapper coordinates11FieldMapper = new Coordinates11.Mapper();

      final Fragments.Mapper fragmentsFieldMapper = new Fragments.Mapper();

      @Override
      public NearestAntennaFromFree2 map(ResponseReader reader) {
        final String __typename = reader.readString($responseFields[0]);
        final Coordinates11 coordinates = reader.readObject($responseFields[1], new ResponseReader.ObjectReader<Coordinates11>() {
          @Override
          public Coordinates11 read(ResponseReader reader) {
            return coordinates11FieldMapper.map(reader);
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
        final Fragments fragments = reader.readConditional((ResponseField.ConditionalTypeField) $responseFields[10], new ResponseReader.ConditionalTypeReader<Fragments>() {
          @Override
          public Fragments read(String conditionalType, ResponseReader reader) {
            return fragmentsFieldMapper.map(reader, conditionalType);
          }
        });
        return new NearestAntennaFromFree2(__typename, coordinates, generation, provider, lastUpdate, status, dist, insee, city, addressLabel, fragments);
      }
    }
  }

  public static class Coordinates11 {
    static final ResponseField[] $responseFields = {
      ResponseField.forDouble("latitude", "latitude", null, true),
      ResponseField.forDouble("longitude", "longitude", null, true)
    };

    final @Nullable Double latitude;

    final @Nullable Double longitude;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public Coordinates11(@Nullable Double latitude, @Nullable Double longitude) {
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
        $toString = "Coordinates11{"
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
      if (o instanceof Coordinates11) {
        Coordinates11 that = (Coordinates11) o;
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

    public static final class Mapper implements ResponseFieldMapper<Coordinates11> {
      @Override
      public Coordinates11 map(ResponseReader reader) {
        final Double latitude = reader.readDouble($responseFields[0]);
        final Double longitude = reader.readDouble($responseFields[1]);
        return new Coordinates11(latitude, longitude);
      }
    }
  }

  public static class AsHouseNumber {
    static final ResponseField[] $responseFields = {
      ResponseField.forString("__typename", "__typename", null, false),
      ResponseField.forString("houseNumber", "houseNumber", null, true),
      ResponseField.forString("street", "street", null, true),
      ResponseField.forString("city", "city", null, true),
      ResponseField.forString("zipCode", "zipCode", null, true),
      ResponseField.forObject("nearestAntennaFromOrange", "nearestAntenna", new UnmodifiableMapBuilder<String, Object>(1)
        .put("provider", "ORANGE")
      .build(), true),
      ResponseField.forObject("nearestAntennaFromBouygues", "nearestAntenna", new UnmodifiableMapBuilder<String, Object>(1)
        .put("provider", "BOUYGUES_TELECOM")
      .build(), true),
      ResponseField.forObject("nearestAntennaFromSfr", "nearestAntenna", new UnmodifiableMapBuilder<String, Object>(1)
        .put("provider", "SFR")
      .build(), true),
      ResponseField.forObject("nearestAntennaFromFree", "nearestAntenna", new UnmodifiableMapBuilder<String, Object>(1)
        .put("provider", "FREE")
      .build(), true)
    };

    final @Nonnull String __typename;

    final @Nullable String houseNumber;

    final @Nullable String street;

    final @Nullable String city;

    final @Nullable String zipCode;

    final @Nullable NearestAntennaFromOrange3 nearestAntennaFromOrange;

    final @Nullable NearestAntennaFromBouygues3 nearestAntennaFromBouygues;

    final @Nullable NearestAntennaFromSfr3 nearestAntennaFromSfr;

    final @Nullable NearestAntennaFromFree3 nearestAntennaFromFree;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public AsHouseNumber(@Nonnull String __typename, @Nullable String houseNumber,
        @Nullable String street, @Nullable String city, @Nullable String zipCode,
        @Nullable NearestAntennaFromOrange3 nearestAntennaFromOrange,
        @Nullable NearestAntennaFromBouygues3 nearestAntennaFromBouygues,
        @Nullable NearestAntennaFromSfr3 nearestAntennaFromSfr,
        @Nullable NearestAntennaFromFree3 nearestAntennaFromFree) {
      if (__typename == null) {
        throw new NullPointerException("__typename can't be null");
      }
      this.__typename = __typename;
      this.houseNumber = houseNumber;
      this.street = street;
      this.city = city;
      this.zipCode = zipCode;
      this.nearestAntennaFromOrange = nearestAntennaFromOrange;
      this.nearestAntennaFromBouygues = nearestAntennaFromBouygues;
      this.nearestAntennaFromSfr = nearestAntennaFromSfr;
      this.nearestAntennaFromFree = nearestAntennaFromFree;
    }

    public @Nonnull String __typename() {
      return this.__typename;
    }

    public @Nullable String houseNumber() {
      return this.houseNumber;
    }

    public @Nullable String street() {
      return this.street;
    }

    public @Nullable String city() {
      return this.city;
    }

    public @Nullable String zipCode() {
      return this.zipCode;
    }

    public @Nullable NearestAntennaFromOrange3 nearestAntennaFromOrange() {
      return this.nearestAntennaFromOrange;
    }

    public @Nullable NearestAntennaFromBouygues3 nearestAntennaFromBouygues() {
      return this.nearestAntennaFromBouygues;
    }

    public @Nullable NearestAntennaFromSfr3 nearestAntennaFromSfr() {
      return this.nearestAntennaFromSfr;
    }

    public @Nullable NearestAntennaFromFree3 nearestAntennaFromFree() {
      return this.nearestAntennaFromFree;
    }

    public ResponseFieldMarshaller marshaller() {
      return new ResponseFieldMarshaller() {
        @Override
        public void marshal(ResponseWriter writer) {
          writer.writeString($responseFields[0], __typename);
          writer.writeString($responseFields[1], houseNumber);
          writer.writeString($responseFields[2], street);
          writer.writeString($responseFields[3], city);
          writer.writeString($responseFields[4], zipCode);
          writer.writeObject($responseFields[5], nearestAntennaFromOrange != null ? nearestAntennaFromOrange.marshaller() : null);
          writer.writeObject($responseFields[6], nearestAntennaFromBouygues != null ? nearestAntennaFromBouygues.marshaller() : null);
          writer.writeObject($responseFields[7], nearestAntennaFromSfr != null ? nearestAntennaFromSfr.marshaller() : null);
          writer.writeObject($responseFields[8], nearestAntennaFromFree != null ? nearestAntennaFromFree.marshaller() : null);
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "AsHouseNumber{"
          + "__typename=" + __typename + ", "
          + "houseNumber=" + houseNumber + ", "
          + "street=" + street + ", "
          + "city=" + city + ", "
          + "zipCode=" + zipCode + ", "
          + "nearestAntennaFromOrange=" + nearestAntennaFromOrange + ", "
          + "nearestAntennaFromBouygues=" + nearestAntennaFromBouygues + ", "
          + "nearestAntennaFromSfr=" + nearestAntennaFromSfr + ", "
          + "nearestAntennaFromFree=" + nearestAntennaFromFree
          + "}";
      }
      return $toString;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (o instanceof AsHouseNumber) {
        AsHouseNumber that = (AsHouseNumber) o;
        return this.__typename.equals(that.__typename)
         && ((this.houseNumber == null) ? (that.houseNumber == null) : this.houseNumber.equals(that.houseNumber))
         && ((this.street == null) ? (that.street == null) : this.street.equals(that.street))
         && ((this.city == null) ? (that.city == null) : this.city.equals(that.city))
         && ((this.zipCode == null) ? (that.zipCode == null) : this.zipCode.equals(that.zipCode))
         && ((this.nearestAntennaFromOrange == null) ? (that.nearestAntennaFromOrange == null) : this.nearestAntennaFromOrange.equals(that.nearestAntennaFromOrange))
         && ((this.nearestAntennaFromBouygues == null) ? (that.nearestAntennaFromBouygues == null) : this.nearestAntennaFromBouygues.equals(that.nearestAntennaFromBouygues))
         && ((this.nearestAntennaFromSfr == null) ? (that.nearestAntennaFromSfr == null) : this.nearestAntennaFromSfr.equals(that.nearestAntennaFromSfr))
         && ((this.nearestAntennaFromFree == null) ? (that.nearestAntennaFromFree == null) : this.nearestAntennaFromFree.equals(that.nearestAntennaFromFree));
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
        h ^= (houseNumber == null) ? 0 : houseNumber.hashCode();
        h *= 1000003;
        h ^= (street == null) ? 0 : street.hashCode();
        h *= 1000003;
        h ^= (city == null) ? 0 : city.hashCode();
        h *= 1000003;
        h ^= (zipCode == null) ? 0 : zipCode.hashCode();
        h *= 1000003;
        h ^= (nearestAntennaFromOrange == null) ? 0 : nearestAntennaFromOrange.hashCode();
        h *= 1000003;
        h ^= (nearestAntennaFromBouygues == null) ? 0 : nearestAntennaFromBouygues.hashCode();
        h *= 1000003;
        h ^= (nearestAntennaFromSfr == null) ? 0 : nearestAntennaFromSfr.hashCode();
        h *= 1000003;
        h ^= (nearestAntennaFromFree == null) ? 0 : nearestAntennaFromFree.hashCode();
        $hashCode = h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    public static final class Mapper implements ResponseFieldMapper<AsHouseNumber> {
      final NearestAntennaFromOrange3.Mapper nearestAntennaFromOrange3FieldMapper = new NearestAntennaFromOrange3.Mapper();

      final NearestAntennaFromBouygues3.Mapper nearestAntennaFromBouygues3FieldMapper = new NearestAntennaFromBouygues3.Mapper();

      final NearestAntennaFromSfr3.Mapper nearestAntennaFromSfr3FieldMapper = new NearestAntennaFromSfr3.Mapper();

      final NearestAntennaFromFree3.Mapper nearestAntennaFromFree3FieldMapper = new NearestAntennaFromFree3.Mapper();

      @Override
      public AsHouseNumber map(ResponseReader reader) {
        final String __typename = reader.readString($responseFields[0]);
        final String houseNumber = reader.readString($responseFields[1]);
        final String street = reader.readString($responseFields[2]);
        final String city = reader.readString($responseFields[3]);
        final String zipCode = reader.readString($responseFields[4]);
        final NearestAntennaFromOrange3 nearestAntennaFromOrange = reader.readObject($responseFields[5], new ResponseReader.ObjectReader<NearestAntennaFromOrange3>() {
          @Override
          public NearestAntennaFromOrange3 read(ResponseReader reader) {
            return nearestAntennaFromOrange3FieldMapper.map(reader);
          }
        });
        final NearestAntennaFromBouygues3 nearestAntennaFromBouygues = reader.readObject($responseFields[6], new ResponseReader.ObjectReader<NearestAntennaFromBouygues3>() {
          @Override
          public NearestAntennaFromBouygues3 read(ResponseReader reader) {
            return nearestAntennaFromBouygues3FieldMapper.map(reader);
          }
        });
        final NearestAntennaFromSfr3 nearestAntennaFromSfr = reader.readObject($responseFields[7], new ResponseReader.ObjectReader<NearestAntennaFromSfr3>() {
          @Override
          public NearestAntennaFromSfr3 read(ResponseReader reader) {
            return nearestAntennaFromSfr3FieldMapper.map(reader);
          }
        });
        final NearestAntennaFromFree3 nearestAntennaFromFree = reader.readObject($responseFields[8], new ResponseReader.ObjectReader<NearestAntennaFromFree3>() {
          @Override
          public NearestAntennaFromFree3 read(ResponseReader reader) {
            return nearestAntennaFromFree3FieldMapper.map(reader);
          }
        });
        return new AsHouseNumber(__typename, houseNumber, street, city, zipCode, nearestAntennaFromOrange, nearestAntennaFromBouygues, nearestAntennaFromSfr, nearestAntennaFromFree);
      }
    }
  }

  public static class NearestAntennaFromOrange3 {
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
      ResponseField.forString("addressLabel", "addressLabel", null, true),
      ResponseField.forFragment("__typename", "__typename", Arrays.asList("NearestAntenna"))
    };

    final @Nonnull String __typename;

    final @Nullable Coordinates12 coordinates;

    final @Nullable String generation;

    final @Nullable String provider;

    final @Nullable String lastUpdate;

    final @Nullable String status;

    final @Nullable Integer dist;

    final @Nullable String insee;

    final @Nullable String city;

    final @Nullable String addressLabel;

    private final @Nonnull Fragments fragments;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public NearestAntennaFromOrange3(@Nonnull String __typename,
        @Nullable Coordinates12 coordinates, @Nullable String generation, @Nullable String provider,
        @Nullable String lastUpdate, @Nullable String status, @Nullable Integer dist,
        @Nullable String insee, @Nullable String city, @Nullable String addressLabel,
        @Nonnull Fragments fragments) {
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
      if (fragments == null) {
        throw new NullPointerException("fragments can't be null");
      }
      this.fragments = fragments;
    }

    public @Nonnull String __typename() {
      return this.__typename;
    }

    public @Nullable Coordinates12 coordinates() {
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

    public @Nonnull Fragments fragments() {
      return this.fragments;
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
          fragments.marshaller().marshal(writer);
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "NearestAntennaFromOrange3{"
          + "__typename=" + __typename + ", "
          + "coordinates=" + coordinates + ", "
          + "generation=" + generation + ", "
          + "provider=" + provider + ", "
          + "lastUpdate=" + lastUpdate + ", "
          + "status=" + status + ", "
          + "dist=" + dist + ", "
          + "insee=" + insee + ", "
          + "city=" + city + ", "
          + "addressLabel=" + addressLabel + ", "
          + "fragments=" + fragments
          + "}";
      }
      return $toString;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (o instanceof NearestAntennaFromOrange3) {
        NearestAntennaFromOrange3 that = (NearestAntennaFromOrange3) o;
        return this.__typename.equals(that.__typename)
         && ((this.coordinates == null) ? (that.coordinates == null) : this.coordinates.equals(that.coordinates))
         && ((this.generation == null) ? (that.generation == null) : this.generation.equals(that.generation))
         && ((this.provider == null) ? (that.provider == null) : this.provider.equals(that.provider))
         && ((this.lastUpdate == null) ? (that.lastUpdate == null) : this.lastUpdate.equals(that.lastUpdate))
         && ((this.status == null) ? (that.status == null) : this.status.equals(that.status))
         && ((this.dist == null) ? (that.dist == null) : this.dist.equals(that.dist))
         && ((this.insee == null) ? (that.insee == null) : this.insee.equals(that.insee))
         && ((this.city == null) ? (that.city == null) : this.city.equals(that.city))
         && ((this.addressLabel == null) ? (that.addressLabel == null) : this.addressLabel.equals(that.addressLabel))
         && this.fragments.equals(that.fragments);
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
        h *= 1000003;
        h ^= fragments.hashCode();
        $hashCode = h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    public static class Fragments {
      final @Nonnull AntennaFields antennaFields;

      private volatile String $toString;

      private volatile int $hashCode;

      private volatile boolean $hashCodeMemoized;

      public Fragments(@Nonnull AntennaFields antennaFields) {
        if (antennaFields == null) {
          throw new NullPointerException("antennaFields can't be null");
        }
        this.antennaFields = antennaFields;
      }

      public @Nonnull AntennaFields antennaFields() {
        return this.antennaFields;
      }

      public ResponseFieldMarshaller marshaller() {
        return new ResponseFieldMarshaller() {
          @Override
          public void marshal(ResponseWriter writer) {
            final AntennaFields $antennaFields = antennaFields;
            if ($antennaFields != null) {
              $antennaFields.marshaller().marshal(writer);
            }
          }
        };
      }

      @Override
      public String toString() {
        if ($toString == null) {
          $toString = "Fragments{"
            + "antennaFields=" + antennaFields
            + "}";
        }
        return $toString;
      }

      @Override
      public boolean equals(Object o) {
        if (o == this) {
          return true;
        }
        if (o instanceof Fragments) {
          Fragments that = (Fragments) o;
          return this.antennaFields.equals(that.antennaFields);
        }
        return false;
      }

      @Override
      public int hashCode() {
        if (!$hashCodeMemoized) {
          int h = 1;
          h *= 1000003;
          h ^= antennaFields.hashCode();
          $hashCode = h;
          $hashCodeMemoized = true;
        }
        return $hashCode;
      }

      public static final class Mapper implements FragmentResponseFieldMapper<Fragments> {
        final AntennaFields.Mapper antennaFieldsFieldMapper = new AntennaFields.Mapper();

        @Override
        public @Nonnull Fragments map(ResponseReader reader, @Nonnull String conditionalType) {
          AntennaFields antennaFields = null;
          if (AntennaFields.POSSIBLE_TYPES.contains(conditionalType)) {
            antennaFields = antennaFieldsFieldMapper.map(reader);
          }
          return new Fragments(antennaFields);
        }
      }
    }

    public static final class Mapper implements ResponseFieldMapper<NearestAntennaFromOrange3> {
      final Coordinates12.Mapper coordinates12FieldMapper = new Coordinates12.Mapper();

      final Fragments.Mapper fragmentsFieldMapper = new Fragments.Mapper();

      @Override
      public NearestAntennaFromOrange3 map(ResponseReader reader) {
        final String __typename = reader.readString($responseFields[0]);
        final Coordinates12 coordinates = reader.readObject($responseFields[1], new ResponseReader.ObjectReader<Coordinates12>() {
          @Override
          public Coordinates12 read(ResponseReader reader) {
            return coordinates12FieldMapper.map(reader);
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
        final Fragments fragments = reader.readConditional((ResponseField.ConditionalTypeField) $responseFields[10], new ResponseReader.ConditionalTypeReader<Fragments>() {
          @Override
          public Fragments read(String conditionalType, ResponseReader reader) {
            return fragmentsFieldMapper.map(reader, conditionalType);
          }
        });
        return new NearestAntennaFromOrange3(__typename, coordinates, generation, provider, lastUpdate, status, dist, insee, city, addressLabel, fragments);
      }
    }
  }

  public static class Coordinates12 {
    static final ResponseField[] $responseFields = {
      ResponseField.forDouble("latitude", "latitude", null, true),
      ResponseField.forDouble("longitude", "longitude", null, true)
    };

    final @Nullable Double latitude;

    final @Nullable Double longitude;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public Coordinates12(@Nullable Double latitude, @Nullable Double longitude) {
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
        $toString = "Coordinates12{"
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
      if (o instanceof Coordinates12) {
        Coordinates12 that = (Coordinates12) o;
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

    public static final class Mapper implements ResponseFieldMapper<Coordinates12> {
      @Override
      public Coordinates12 map(ResponseReader reader) {
        final Double latitude = reader.readDouble($responseFields[0]);
        final Double longitude = reader.readDouble($responseFields[1]);
        return new Coordinates12(latitude, longitude);
      }
    }
  }

  public static class NearestAntennaFromBouygues3 {
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
      ResponseField.forString("addressLabel", "addressLabel", null, true),
      ResponseField.forFragment("__typename", "__typename", Arrays.asList("NearestAntenna"))
    };

    final @Nonnull String __typename;

    final @Nullable Coordinates13 coordinates;

    final @Nullable String generation;

    final @Nullable String provider;

    final @Nullable String lastUpdate;

    final @Nullable String status;

    final @Nullable Integer dist;

    final @Nullable String insee;

    final @Nullable String city;

    final @Nullable String addressLabel;

    private final @Nonnull Fragments fragments;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public NearestAntennaFromBouygues3(@Nonnull String __typename,
        @Nullable Coordinates13 coordinates, @Nullable String generation, @Nullable String provider,
        @Nullable String lastUpdate, @Nullable String status, @Nullable Integer dist,
        @Nullable String insee, @Nullable String city, @Nullable String addressLabel,
        @Nonnull Fragments fragments) {
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
      if (fragments == null) {
        throw new NullPointerException("fragments can't be null");
      }
      this.fragments = fragments;
    }

    public @Nonnull String __typename() {
      return this.__typename;
    }

    public @Nullable Coordinates13 coordinates() {
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

    public @Nonnull Fragments fragments() {
      return this.fragments;
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
          fragments.marshaller().marshal(writer);
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "NearestAntennaFromBouygues3{"
          + "__typename=" + __typename + ", "
          + "coordinates=" + coordinates + ", "
          + "generation=" + generation + ", "
          + "provider=" + provider + ", "
          + "lastUpdate=" + lastUpdate + ", "
          + "status=" + status + ", "
          + "dist=" + dist + ", "
          + "insee=" + insee + ", "
          + "city=" + city + ", "
          + "addressLabel=" + addressLabel + ", "
          + "fragments=" + fragments
          + "}";
      }
      return $toString;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (o instanceof NearestAntennaFromBouygues3) {
        NearestAntennaFromBouygues3 that = (NearestAntennaFromBouygues3) o;
        return this.__typename.equals(that.__typename)
         && ((this.coordinates == null) ? (that.coordinates == null) : this.coordinates.equals(that.coordinates))
         && ((this.generation == null) ? (that.generation == null) : this.generation.equals(that.generation))
         && ((this.provider == null) ? (that.provider == null) : this.provider.equals(that.provider))
         && ((this.lastUpdate == null) ? (that.lastUpdate == null) : this.lastUpdate.equals(that.lastUpdate))
         && ((this.status == null) ? (that.status == null) : this.status.equals(that.status))
         && ((this.dist == null) ? (that.dist == null) : this.dist.equals(that.dist))
         && ((this.insee == null) ? (that.insee == null) : this.insee.equals(that.insee))
         && ((this.city == null) ? (that.city == null) : this.city.equals(that.city))
         && ((this.addressLabel == null) ? (that.addressLabel == null) : this.addressLabel.equals(that.addressLabel))
         && this.fragments.equals(that.fragments);
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
        h *= 1000003;
        h ^= fragments.hashCode();
        $hashCode = h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    public static class Fragments {
      final @Nonnull AntennaFields antennaFields;

      private volatile String $toString;

      private volatile int $hashCode;

      private volatile boolean $hashCodeMemoized;

      public Fragments(@Nonnull AntennaFields antennaFields) {
        if (antennaFields == null) {
          throw new NullPointerException("antennaFields can't be null");
        }
        this.antennaFields = antennaFields;
      }

      public @Nonnull AntennaFields antennaFields() {
        return this.antennaFields;
      }

      public ResponseFieldMarshaller marshaller() {
        return new ResponseFieldMarshaller() {
          @Override
          public void marshal(ResponseWriter writer) {
            final AntennaFields $antennaFields = antennaFields;
            if ($antennaFields != null) {
              $antennaFields.marshaller().marshal(writer);
            }
          }
        };
      }

      @Override
      public String toString() {
        if ($toString == null) {
          $toString = "Fragments{"
            + "antennaFields=" + antennaFields
            + "}";
        }
        return $toString;
      }

      @Override
      public boolean equals(Object o) {
        if (o == this) {
          return true;
        }
        if (o instanceof Fragments) {
          Fragments that = (Fragments) o;
          return this.antennaFields.equals(that.antennaFields);
        }
        return false;
      }

      @Override
      public int hashCode() {
        if (!$hashCodeMemoized) {
          int h = 1;
          h *= 1000003;
          h ^= antennaFields.hashCode();
          $hashCode = h;
          $hashCodeMemoized = true;
        }
        return $hashCode;
      }

      public static final class Mapper implements FragmentResponseFieldMapper<Fragments> {
        final AntennaFields.Mapper antennaFieldsFieldMapper = new AntennaFields.Mapper();

        @Override
        public @Nonnull Fragments map(ResponseReader reader, @Nonnull String conditionalType) {
          AntennaFields antennaFields = null;
          if (AntennaFields.POSSIBLE_TYPES.contains(conditionalType)) {
            antennaFields = antennaFieldsFieldMapper.map(reader);
          }
          return new Fragments(antennaFields);
        }
      }
    }

    public static final class Mapper implements ResponseFieldMapper<NearestAntennaFromBouygues3> {
      final Coordinates13.Mapper coordinates13FieldMapper = new Coordinates13.Mapper();

      final Fragments.Mapper fragmentsFieldMapper = new Fragments.Mapper();

      @Override
      public NearestAntennaFromBouygues3 map(ResponseReader reader) {
        final String __typename = reader.readString($responseFields[0]);
        final Coordinates13 coordinates = reader.readObject($responseFields[1], new ResponseReader.ObjectReader<Coordinates13>() {
          @Override
          public Coordinates13 read(ResponseReader reader) {
            return coordinates13FieldMapper.map(reader);
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
        final Fragments fragments = reader.readConditional((ResponseField.ConditionalTypeField) $responseFields[10], new ResponseReader.ConditionalTypeReader<Fragments>() {
          @Override
          public Fragments read(String conditionalType, ResponseReader reader) {
            return fragmentsFieldMapper.map(reader, conditionalType);
          }
        });
        return new NearestAntennaFromBouygues3(__typename, coordinates, generation, provider, lastUpdate, status, dist, insee, city, addressLabel, fragments);
      }
    }
  }

  public static class Coordinates13 {
    static final ResponseField[] $responseFields = {
      ResponseField.forDouble("latitude", "latitude", null, true),
      ResponseField.forDouble("longitude", "longitude", null, true)
    };

    final @Nullable Double latitude;

    final @Nullable Double longitude;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public Coordinates13(@Nullable Double latitude, @Nullable Double longitude) {
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
        $toString = "Coordinates13{"
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
      if (o instanceof Coordinates13) {
        Coordinates13 that = (Coordinates13) o;
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

    public static final class Mapper implements ResponseFieldMapper<Coordinates13> {
      @Override
      public Coordinates13 map(ResponseReader reader) {
        final Double latitude = reader.readDouble($responseFields[0]);
        final Double longitude = reader.readDouble($responseFields[1]);
        return new Coordinates13(latitude, longitude);
      }
    }
  }

  public static class NearestAntennaFromSfr3 {
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
      ResponseField.forString("addressLabel", "addressLabel", null, true),
      ResponseField.forFragment("__typename", "__typename", Arrays.asList("NearestAntenna"))
    };

    final @Nonnull String __typename;

    final @Nullable Coordinates14 coordinates;

    final @Nullable String generation;

    final @Nullable String provider;

    final @Nullable String lastUpdate;

    final @Nullable String status;

    final @Nullable Integer dist;

    final @Nullable String insee;

    final @Nullable String city;

    final @Nullable String addressLabel;

    private final @Nonnull Fragments fragments;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public NearestAntennaFromSfr3(@Nonnull String __typename, @Nullable Coordinates14 coordinates,
        @Nullable String generation, @Nullable String provider, @Nullable String lastUpdate,
        @Nullable String status, @Nullable Integer dist, @Nullable String insee,
        @Nullable String city, @Nullable String addressLabel, @Nonnull Fragments fragments) {
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
      if (fragments == null) {
        throw new NullPointerException("fragments can't be null");
      }
      this.fragments = fragments;
    }

    public @Nonnull String __typename() {
      return this.__typename;
    }

    public @Nullable Coordinates14 coordinates() {
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

    public @Nonnull Fragments fragments() {
      return this.fragments;
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
          fragments.marshaller().marshal(writer);
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "NearestAntennaFromSfr3{"
          + "__typename=" + __typename + ", "
          + "coordinates=" + coordinates + ", "
          + "generation=" + generation + ", "
          + "provider=" + provider + ", "
          + "lastUpdate=" + lastUpdate + ", "
          + "status=" + status + ", "
          + "dist=" + dist + ", "
          + "insee=" + insee + ", "
          + "city=" + city + ", "
          + "addressLabel=" + addressLabel + ", "
          + "fragments=" + fragments
          + "}";
      }
      return $toString;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (o instanceof NearestAntennaFromSfr3) {
        NearestAntennaFromSfr3 that = (NearestAntennaFromSfr3) o;
        return this.__typename.equals(that.__typename)
         && ((this.coordinates == null) ? (that.coordinates == null) : this.coordinates.equals(that.coordinates))
         && ((this.generation == null) ? (that.generation == null) : this.generation.equals(that.generation))
         && ((this.provider == null) ? (that.provider == null) : this.provider.equals(that.provider))
         && ((this.lastUpdate == null) ? (that.lastUpdate == null) : this.lastUpdate.equals(that.lastUpdate))
         && ((this.status == null) ? (that.status == null) : this.status.equals(that.status))
         && ((this.dist == null) ? (that.dist == null) : this.dist.equals(that.dist))
         && ((this.insee == null) ? (that.insee == null) : this.insee.equals(that.insee))
         && ((this.city == null) ? (that.city == null) : this.city.equals(that.city))
         && ((this.addressLabel == null) ? (that.addressLabel == null) : this.addressLabel.equals(that.addressLabel))
         && this.fragments.equals(that.fragments);
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
        h *= 1000003;
        h ^= fragments.hashCode();
        $hashCode = h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    public static class Fragments {
      final @Nonnull AntennaFields antennaFields;

      private volatile String $toString;

      private volatile int $hashCode;

      private volatile boolean $hashCodeMemoized;

      public Fragments(@Nonnull AntennaFields antennaFields) {
        if (antennaFields == null) {
          throw new NullPointerException("antennaFields can't be null");
        }
        this.antennaFields = antennaFields;
      }

      public @Nonnull AntennaFields antennaFields() {
        return this.antennaFields;
      }

      public ResponseFieldMarshaller marshaller() {
        return new ResponseFieldMarshaller() {
          @Override
          public void marshal(ResponseWriter writer) {
            final AntennaFields $antennaFields = antennaFields;
            if ($antennaFields != null) {
              $antennaFields.marshaller().marshal(writer);
            }
          }
        };
      }

      @Override
      public String toString() {
        if ($toString == null) {
          $toString = "Fragments{"
            + "antennaFields=" + antennaFields
            + "}";
        }
        return $toString;
      }

      @Override
      public boolean equals(Object o) {
        if (o == this) {
          return true;
        }
        if (o instanceof Fragments) {
          Fragments that = (Fragments) o;
          return this.antennaFields.equals(that.antennaFields);
        }
        return false;
      }

      @Override
      public int hashCode() {
        if (!$hashCodeMemoized) {
          int h = 1;
          h *= 1000003;
          h ^= antennaFields.hashCode();
          $hashCode = h;
          $hashCodeMemoized = true;
        }
        return $hashCode;
      }

      public static final class Mapper implements FragmentResponseFieldMapper<Fragments> {
        final AntennaFields.Mapper antennaFieldsFieldMapper = new AntennaFields.Mapper();

        @Override
        public @Nonnull Fragments map(ResponseReader reader, @Nonnull String conditionalType) {
          AntennaFields antennaFields = null;
          if (AntennaFields.POSSIBLE_TYPES.contains(conditionalType)) {
            antennaFields = antennaFieldsFieldMapper.map(reader);
          }
          return new Fragments(antennaFields);
        }
      }
    }

    public static final class Mapper implements ResponseFieldMapper<NearestAntennaFromSfr3> {
      final Coordinates14.Mapper coordinates14FieldMapper = new Coordinates14.Mapper();

      final Fragments.Mapper fragmentsFieldMapper = new Fragments.Mapper();

      @Override
      public NearestAntennaFromSfr3 map(ResponseReader reader) {
        final String __typename = reader.readString($responseFields[0]);
        final Coordinates14 coordinates = reader.readObject($responseFields[1], new ResponseReader.ObjectReader<Coordinates14>() {
          @Override
          public Coordinates14 read(ResponseReader reader) {
            return coordinates14FieldMapper.map(reader);
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
        final Fragments fragments = reader.readConditional((ResponseField.ConditionalTypeField) $responseFields[10], new ResponseReader.ConditionalTypeReader<Fragments>() {
          @Override
          public Fragments read(String conditionalType, ResponseReader reader) {
            return fragmentsFieldMapper.map(reader, conditionalType);
          }
        });
        return new NearestAntennaFromSfr3(__typename, coordinates, generation, provider, lastUpdate, status, dist, insee, city, addressLabel, fragments);
      }
    }
  }

  public static class Coordinates14 {
    static final ResponseField[] $responseFields = {
      ResponseField.forDouble("latitude", "latitude", null, true),
      ResponseField.forDouble("longitude", "longitude", null, true)
    };

    final @Nullable Double latitude;

    final @Nullable Double longitude;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public Coordinates14(@Nullable Double latitude, @Nullable Double longitude) {
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
        $toString = "Coordinates14{"
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
      if (o instanceof Coordinates14) {
        Coordinates14 that = (Coordinates14) o;
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

    public static final class Mapper implements ResponseFieldMapper<Coordinates14> {
      @Override
      public Coordinates14 map(ResponseReader reader) {
        final Double latitude = reader.readDouble($responseFields[0]);
        final Double longitude = reader.readDouble($responseFields[1]);
        return new Coordinates14(latitude, longitude);
      }
    }
  }

  public static class NearestAntennaFromFree3 {
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
      ResponseField.forString("addressLabel", "addressLabel", null, true),
      ResponseField.forFragment("__typename", "__typename", Arrays.asList("NearestAntenna"))
    };

    final @Nonnull String __typename;

    final @Nullable Coordinates15 coordinates;

    final @Nullable String generation;

    final @Nullable String provider;

    final @Nullable String lastUpdate;

    final @Nullable String status;

    final @Nullable Integer dist;

    final @Nullable String insee;

    final @Nullable String city;

    final @Nullable String addressLabel;

    private final @Nonnull Fragments fragments;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public NearestAntennaFromFree3(@Nonnull String __typename, @Nullable Coordinates15 coordinates,
        @Nullable String generation, @Nullable String provider, @Nullable String lastUpdate,
        @Nullable String status, @Nullable Integer dist, @Nullable String insee,
        @Nullable String city, @Nullable String addressLabel, @Nonnull Fragments fragments) {
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
      if (fragments == null) {
        throw new NullPointerException("fragments can't be null");
      }
      this.fragments = fragments;
    }

    public @Nonnull String __typename() {
      return this.__typename;
    }

    public @Nullable Coordinates15 coordinates() {
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

    public @Nonnull Fragments fragments() {
      return this.fragments;
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
          fragments.marshaller().marshal(writer);
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "NearestAntennaFromFree3{"
          + "__typename=" + __typename + ", "
          + "coordinates=" + coordinates + ", "
          + "generation=" + generation + ", "
          + "provider=" + provider + ", "
          + "lastUpdate=" + lastUpdate + ", "
          + "status=" + status + ", "
          + "dist=" + dist + ", "
          + "insee=" + insee + ", "
          + "city=" + city + ", "
          + "addressLabel=" + addressLabel + ", "
          + "fragments=" + fragments
          + "}";
      }
      return $toString;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (o instanceof NearestAntennaFromFree3) {
        NearestAntennaFromFree3 that = (NearestAntennaFromFree3) o;
        return this.__typename.equals(that.__typename)
         && ((this.coordinates == null) ? (that.coordinates == null) : this.coordinates.equals(that.coordinates))
         && ((this.generation == null) ? (that.generation == null) : this.generation.equals(that.generation))
         && ((this.provider == null) ? (that.provider == null) : this.provider.equals(that.provider))
         && ((this.lastUpdate == null) ? (that.lastUpdate == null) : this.lastUpdate.equals(that.lastUpdate))
         && ((this.status == null) ? (that.status == null) : this.status.equals(that.status))
         && ((this.dist == null) ? (that.dist == null) : this.dist.equals(that.dist))
         && ((this.insee == null) ? (that.insee == null) : this.insee.equals(that.insee))
         && ((this.city == null) ? (that.city == null) : this.city.equals(that.city))
         && ((this.addressLabel == null) ? (that.addressLabel == null) : this.addressLabel.equals(that.addressLabel))
         && this.fragments.equals(that.fragments);
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
        h *= 1000003;
        h ^= fragments.hashCode();
        $hashCode = h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    public static class Fragments {
      final @Nonnull AntennaFields antennaFields;

      private volatile String $toString;

      private volatile int $hashCode;

      private volatile boolean $hashCodeMemoized;

      public Fragments(@Nonnull AntennaFields antennaFields) {
        if (antennaFields == null) {
          throw new NullPointerException("antennaFields can't be null");
        }
        this.antennaFields = antennaFields;
      }

      public @Nonnull AntennaFields antennaFields() {
        return this.antennaFields;
      }

      public ResponseFieldMarshaller marshaller() {
        return new ResponseFieldMarshaller() {
          @Override
          public void marshal(ResponseWriter writer) {
            final AntennaFields $antennaFields = antennaFields;
            if ($antennaFields != null) {
              $antennaFields.marshaller().marshal(writer);
            }
          }
        };
      }

      @Override
      public String toString() {
        if ($toString == null) {
          $toString = "Fragments{"
            + "antennaFields=" + antennaFields
            + "}";
        }
        return $toString;
      }

      @Override
      public boolean equals(Object o) {
        if (o == this) {
          return true;
        }
        if (o instanceof Fragments) {
          Fragments that = (Fragments) o;
          return this.antennaFields.equals(that.antennaFields);
        }
        return false;
      }

      @Override
      public int hashCode() {
        if (!$hashCodeMemoized) {
          int h = 1;
          h *= 1000003;
          h ^= antennaFields.hashCode();
          $hashCode = h;
          $hashCodeMemoized = true;
        }
        return $hashCode;
      }

      public static final class Mapper implements FragmentResponseFieldMapper<Fragments> {
        final AntennaFields.Mapper antennaFieldsFieldMapper = new AntennaFields.Mapper();

        @Override
        public @Nonnull Fragments map(ResponseReader reader, @Nonnull String conditionalType) {
          AntennaFields antennaFields = null;
          if (AntennaFields.POSSIBLE_TYPES.contains(conditionalType)) {
            antennaFields = antennaFieldsFieldMapper.map(reader);
          }
          return new Fragments(antennaFields);
        }
      }
    }

    public static final class Mapper implements ResponseFieldMapper<NearestAntennaFromFree3> {
      final Coordinates15.Mapper coordinates15FieldMapper = new Coordinates15.Mapper();

      final Fragments.Mapper fragmentsFieldMapper = new Fragments.Mapper();

      @Override
      public NearestAntennaFromFree3 map(ResponseReader reader) {
        final String __typename = reader.readString($responseFields[0]);
        final Coordinates15 coordinates = reader.readObject($responseFields[1], new ResponseReader.ObjectReader<Coordinates15>() {
          @Override
          public Coordinates15 read(ResponseReader reader) {
            return coordinates15FieldMapper.map(reader);
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
        final Fragments fragments = reader.readConditional((ResponseField.ConditionalTypeField) $responseFields[10], new ResponseReader.ConditionalTypeReader<Fragments>() {
          @Override
          public Fragments read(String conditionalType, ResponseReader reader) {
            return fragmentsFieldMapper.map(reader, conditionalType);
          }
        });
        return new NearestAntennaFromFree3(__typename, coordinates, generation, provider, lastUpdate, status, dist, insee, city, addressLabel, fragments);
      }
    }
  }

  public static class Coordinates15 {
    static final ResponseField[] $responseFields = {
      ResponseField.forDouble("latitude", "latitude", null, true),
      ResponseField.forDouble("longitude", "longitude", null, true)
    };

    final @Nullable Double latitude;

    final @Nullable Double longitude;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public Coordinates15(@Nullable Double latitude, @Nullable Double longitude) {
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
        $toString = "Coordinates15{"
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
      if (o instanceof Coordinates15) {
        Coordinates15 that = (Coordinates15) o;
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

    public static final class Mapper implements ResponseFieldMapper<Coordinates15> {
      @Override
      public Coordinates15 map(ResponseReader reader) {
        final Double latitude = reader.readDouble($responseFields[0]);
        final Double longitude = reader.readDouble($responseFields[1]);
        return new Coordinates15(latitude, longitude);
      }
    }
  }
}
