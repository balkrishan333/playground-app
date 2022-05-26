// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: enumurations.proto

package com.nagpal.bala.playgroundapp.protobuf.generated;

public final class EnumurationsOuterClass {
  private EnumurationsOuterClass() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  /**
   * Protobuf enum {@code com.nagpal.bala.playgroundapp.protobuf.generated.EYE_COLOR}
   */
  public enum EYE_COLOR
      implements com.google.protobuf.ProtocolMessageEnum {
    /**
     * <code>EYE_COLOR_UNDEFINED = 0;</code>
     */
    EYE_COLOR_UNDEFINED(0),
    /**
     * <code>EYE_COLOR_BLUE = 1;</code>
     */
    EYE_COLOR_BLUE(1),
    /**
     * <code>EYE_COLOR_GREEN = 2;</code>
     */
    EYE_COLOR_GREEN(2),
    /**
     * <code>EYE_COLOR_BROWN = 3;</code>
     */
    EYE_COLOR_BROWN(3),
    UNRECOGNIZED(-1),
    ;

    /**
     * <code>EYE_COLOR_UNDEFINED = 0;</code>
     */
    public static final int EYE_COLOR_UNDEFINED_VALUE = 0;
    /**
     * <code>EYE_COLOR_BLUE = 1;</code>
     */
    public static final int EYE_COLOR_BLUE_VALUE = 1;
    /**
     * <code>EYE_COLOR_GREEN = 2;</code>
     */
    public static final int EYE_COLOR_GREEN_VALUE = 2;
    /**
     * <code>EYE_COLOR_BROWN = 3;</code>
     */
    public static final int EYE_COLOR_BROWN_VALUE = 3;


    public final int getNumber() {
      if (this == UNRECOGNIZED) {
        throw new java.lang.IllegalArgumentException(
            "Can't get the number of an unknown enum value.");
      }
      return value;
    }

    /**
     * @param value The numeric wire value of the corresponding enum entry.
     * @return The enum associated with the given numeric wire value.
     * @deprecated Use {@link #forNumber(int)} instead.
     */
    @java.lang.Deprecated
    public static EYE_COLOR valueOf(int value) {
      return forNumber(value);
    }

    /**
     * @param value The numeric wire value of the corresponding enum entry.
     * @return The enum associated with the given numeric wire value.
     */
    public static EYE_COLOR forNumber(int value) {
      switch (value) {
        case 0: return EYE_COLOR_UNDEFINED;
        case 1: return EYE_COLOR_BLUE;
        case 2: return EYE_COLOR_GREEN;
        case 3: return EYE_COLOR_BROWN;
        default: return null;
      }
    }

    public static com.google.protobuf.Internal.EnumLiteMap<EYE_COLOR>
        internalGetValueMap() {
      return internalValueMap;
    }
    private static final com.google.protobuf.Internal.EnumLiteMap<
        EYE_COLOR> internalValueMap =
          new com.google.protobuf.Internal.EnumLiteMap<EYE_COLOR>() {
            public EYE_COLOR findValueByNumber(int number) {
              return EYE_COLOR.forNumber(number);
            }
          };

    public final com.google.protobuf.Descriptors.EnumValueDescriptor
        getValueDescriptor() {
      if (this == UNRECOGNIZED) {
        throw new java.lang.IllegalStateException(
            "Can't get the descriptor of an unrecognized enum value.");
      }
      return getDescriptor().getValues().get(ordinal());
    }
    public final com.google.protobuf.Descriptors.EnumDescriptor
        getDescriptorForType() {
      return getDescriptor();
    }
    public static final com.google.protobuf.Descriptors.EnumDescriptor
        getDescriptor() {
      return com.nagpal.bala.playgroundapp.protobuf.generated.EnumurationsOuterClass.getDescriptor().getEnumTypes().get(0);
    }

    private static final EYE_COLOR[] VALUES = values();

    public static EYE_COLOR valueOf(
        com.google.protobuf.Descriptors.EnumValueDescriptor desc) {
      if (desc.getType() != getDescriptor()) {
        throw new java.lang.IllegalArgumentException(
          "EnumValueDescriptor is not for this type.");
      }
      if (desc.getIndex() == -1) {
        return UNRECOGNIZED;
      }
      return VALUES[desc.getIndex()];
    }

    private final int value;

    private EYE_COLOR(int value) {
      this.value = value;
    }

    // @@protoc_insertion_point(enum_scope:com.nagpal.bala.playgroundapp.protobuf.generated.EYE_COLOR)
  }

  public interface EnumurationsOrBuilder extends
      // @@protoc_insertion_point(interface_extends:com.nagpal.bala.playgroundapp.protobuf.generated.Enumurations)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>.com.nagpal.bala.playgroundapp.protobuf.generated.EYE_COLOR eye_color = 1;</code>
     * @return The enum numeric value on the wire for eyeColor.
     */
    int getEyeColorValue();
    /**
     * <code>.com.nagpal.bala.playgroundapp.protobuf.generated.EYE_COLOR eye_color = 1;</code>
     * @return The eyeColor.
     */
    com.nagpal.bala.playgroundapp.protobuf.generated.EnumurationsOuterClass.EYE_COLOR getEyeColor();
  }
  /**
   * Protobuf type {@code com.nagpal.bala.playgroundapp.protobuf.generated.Enumurations}
   */
  public static final class Enumurations extends
      com.google.protobuf.GeneratedMessageV3 implements
      // @@protoc_insertion_point(message_implements:com.nagpal.bala.playgroundapp.protobuf.generated.Enumurations)
      EnumurationsOrBuilder {
  private static final long serialVersionUID = 0L;
    // Use Enumurations.newBuilder() to construct.
    private Enumurations(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }
    private Enumurations() {
      eyeColor_ = 0;
    }

    @java.lang.Override
    @SuppressWarnings({"unused"})
    protected java.lang.Object newInstance(
        UnusedPrivateParameter unused) {
      return new Enumurations();
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return this.unknownFields;
    }
    private Enumurations(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      this();
      if (extensionRegistry == null) {
        throw new java.lang.NullPointerException();
      }
      com.google.protobuf.UnknownFieldSet.Builder unknownFields =
          com.google.protobuf.UnknownFieldSet.newBuilder();
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            case 8: {
              int rawValue = input.readEnum();

              eyeColor_ = rawValue;
              break;
            }
            default: {
              if (!parseUnknownField(
                  input, unknownFields, extensionRegistry, tag)) {
                done = true;
              }
              break;
            }
          }
        }
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(this);
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(
            e).setUnfinishedMessage(this);
      } finally {
        this.unknownFields = unknownFields.build();
        makeExtensionsImmutable();
      }
    }
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.nagpal.bala.playgroundapp.protobuf.generated.EnumurationsOuterClass.internal_static_com_nagpal_bala_playgroundapp_protobuf_generated_Enumurations_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.nagpal.bala.playgroundapp.protobuf.generated.EnumurationsOuterClass.internal_static_com_nagpal_bala_playgroundapp_protobuf_generated_Enumurations_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.nagpal.bala.playgroundapp.protobuf.generated.EnumurationsOuterClass.Enumurations.class, com.nagpal.bala.playgroundapp.protobuf.generated.EnumurationsOuterClass.Enumurations.Builder.class);
    }

    public static final int EYE_COLOR_FIELD_NUMBER = 1;
    private int eyeColor_;
    /**
     * <code>.com.nagpal.bala.playgroundapp.protobuf.generated.EYE_COLOR eye_color = 1;</code>
     * @return The enum numeric value on the wire for eyeColor.
     */
    @java.lang.Override public int getEyeColorValue() {
      return eyeColor_;
    }
    /**
     * <code>.com.nagpal.bala.playgroundapp.protobuf.generated.EYE_COLOR eye_color = 1;</code>
     * @return The eyeColor.
     */
    @java.lang.Override public com.nagpal.bala.playgroundapp.protobuf.generated.EnumurationsOuterClass.EYE_COLOR getEyeColor() {
      @SuppressWarnings("deprecation")
      com.nagpal.bala.playgroundapp.protobuf.generated.EnumurationsOuterClass.EYE_COLOR result = com.nagpal.bala.playgroundapp.protobuf.generated.EnumurationsOuterClass.EYE_COLOR.valueOf(eyeColor_);
      return result == null ? com.nagpal.bala.playgroundapp.protobuf.generated.EnumurationsOuterClass.EYE_COLOR.UNRECOGNIZED : result;
    }

    private byte memoizedIsInitialized = -1;
    @java.lang.Override
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized == 1) return true;
      if (isInitialized == 0) return false;

      memoizedIsInitialized = 1;
      return true;
    }

    @java.lang.Override
    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      if (eyeColor_ != com.nagpal.bala.playgroundapp.protobuf.generated.EnumurationsOuterClass.EYE_COLOR.EYE_COLOR_UNDEFINED.getNumber()) {
        output.writeEnum(1, eyeColor_);
      }
      unknownFields.writeTo(output);
    }

    @java.lang.Override
    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (eyeColor_ != com.nagpal.bala.playgroundapp.protobuf.generated.EnumurationsOuterClass.EYE_COLOR.EYE_COLOR_UNDEFINED.getNumber()) {
        size += com.google.protobuf.CodedOutputStream
          .computeEnumSize(1, eyeColor_);
      }
      size += unknownFields.getSerializedSize();
      memoizedSize = size;
      return size;
    }

    @java.lang.Override
    public boolean equals(final java.lang.Object obj) {
      if (obj == this) {
       return true;
      }
      if (!(obj instanceof com.nagpal.bala.playgroundapp.protobuf.generated.EnumurationsOuterClass.Enumurations)) {
        return super.equals(obj);
      }
      com.nagpal.bala.playgroundapp.protobuf.generated.EnumurationsOuterClass.Enumurations other = (com.nagpal.bala.playgroundapp.protobuf.generated.EnumurationsOuterClass.Enumurations) obj;

      if (eyeColor_ != other.eyeColor_) return false;
      if (!unknownFields.equals(other.unknownFields)) return false;
      return true;
    }

    @java.lang.Override
    public int hashCode() {
      if (memoizedHashCode != 0) {
        return memoizedHashCode;
      }
      int hash = 41;
      hash = (19 * hash) + getDescriptor().hashCode();
      hash = (37 * hash) + EYE_COLOR_FIELD_NUMBER;
      hash = (53 * hash) + eyeColor_;
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static com.nagpal.bala.playgroundapp.protobuf.generated.EnumurationsOuterClass.Enumurations parseFrom(
        java.nio.ByteBuffer data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static com.nagpal.bala.playgroundapp.protobuf.generated.EnumurationsOuterClass.Enumurations parseFrom(
        java.nio.ByteBuffer data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static com.nagpal.bala.playgroundapp.protobuf.generated.EnumurationsOuterClass.Enumurations parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static com.nagpal.bala.playgroundapp.protobuf.generated.EnumurationsOuterClass.Enumurations parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static com.nagpal.bala.playgroundapp.protobuf.generated.EnumurationsOuterClass.Enumurations parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static com.nagpal.bala.playgroundapp.protobuf.generated.EnumurationsOuterClass.Enumurations parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static com.nagpal.bala.playgroundapp.protobuf.generated.EnumurationsOuterClass.Enumurations parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static com.nagpal.bala.playgroundapp.protobuf.generated.EnumurationsOuterClass.Enumurations parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }
    public static com.nagpal.bala.playgroundapp.protobuf.generated.EnumurationsOuterClass.Enumurations parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input);
    }
    public static com.nagpal.bala.playgroundapp.protobuf.generated.EnumurationsOuterClass.Enumurations parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static com.nagpal.bala.playgroundapp.protobuf.generated.EnumurationsOuterClass.Enumurations parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static com.nagpal.bala.playgroundapp.protobuf.generated.EnumurationsOuterClass.Enumurations parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }

    @java.lang.Override
    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
    }
    public static Builder newBuilder(com.nagpal.bala.playgroundapp.protobuf.generated.EnumurationsOuterClass.Enumurations prototype) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
    }
    @java.lang.Override
    public Builder toBuilder() {
      return this == DEFAULT_INSTANCE
          ? new Builder() : new Builder().mergeFrom(this);
    }

    @java.lang.Override
    protected Builder newBuilderForType(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      Builder builder = new Builder(parent);
      return builder;
    }
    /**
     * Protobuf type {@code com.nagpal.bala.playgroundapp.protobuf.generated.Enumurations}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:com.nagpal.bala.playgroundapp.protobuf.generated.Enumurations)
        com.nagpal.bala.playgroundapp.protobuf.generated.EnumurationsOuterClass.EnumurationsOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return com.nagpal.bala.playgroundapp.protobuf.generated.EnumurationsOuterClass.internal_static_com_nagpal_bala_playgroundapp_protobuf_generated_Enumurations_descriptor;
      }

      @java.lang.Override
      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return com.nagpal.bala.playgroundapp.protobuf.generated.EnumurationsOuterClass.internal_static_com_nagpal_bala_playgroundapp_protobuf_generated_Enumurations_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                com.nagpal.bala.playgroundapp.protobuf.generated.EnumurationsOuterClass.Enumurations.class, com.nagpal.bala.playgroundapp.protobuf.generated.EnumurationsOuterClass.Enumurations.Builder.class);
      }

      // Construct using com.nagpal.bala.playgroundapp.protobuf.generated.EnumurationsOuterClass.Enumurations.newBuilder()
      private Builder() {
        maybeForceBuilderInitialization();
      }

      private Builder(
          com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
        super(parent);
        maybeForceBuilderInitialization();
      }
      private void maybeForceBuilderInitialization() {
        if (com.google.protobuf.GeneratedMessageV3
                .alwaysUseFieldBuilders) {
        }
      }
      @java.lang.Override
      public Builder clear() {
        super.clear();
        eyeColor_ = 0;

        return this;
      }

      @java.lang.Override
      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return com.nagpal.bala.playgroundapp.protobuf.generated.EnumurationsOuterClass.internal_static_com_nagpal_bala_playgroundapp_protobuf_generated_Enumurations_descriptor;
      }

      @java.lang.Override
      public com.nagpal.bala.playgroundapp.protobuf.generated.EnumurationsOuterClass.Enumurations getDefaultInstanceForType() {
        return com.nagpal.bala.playgroundapp.protobuf.generated.EnumurationsOuterClass.Enumurations.getDefaultInstance();
      }

      @java.lang.Override
      public com.nagpal.bala.playgroundapp.protobuf.generated.EnumurationsOuterClass.Enumurations build() {
        com.nagpal.bala.playgroundapp.protobuf.generated.EnumurationsOuterClass.Enumurations result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      @java.lang.Override
      public com.nagpal.bala.playgroundapp.protobuf.generated.EnumurationsOuterClass.Enumurations buildPartial() {
        com.nagpal.bala.playgroundapp.protobuf.generated.EnumurationsOuterClass.Enumurations result = new com.nagpal.bala.playgroundapp.protobuf.generated.EnumurationsOuterClass.Enumurations(this);
        result.eyeColor_ = eyeColor_;
        onBuilt();
        return result;
      }

      @java.lang.Override
      public Builder clone() {
        return super.clone();
      }
      @java.lang.Override
      public Builder setField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          java.lang.Object value) {
        return super.setField(field, value);
      }
      @java.lang.Override
      public Builder clearField(
          com.google.protobuf.Descriptors.FieldDescriptor field) {
        return super.clearField(field);
      }
      @java.lang.Override
      public Builder clearOneof(
          com.google.protobuf.Descriptors.OneofDescriptor oneof) {
        return super.clearOneof(oneof);
      }
      @java.lang.Override
      public Builder setRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          int index, java.lang.Object value) {
        return super.setRepeatedField(field, index, value);
      }
      @java.lang.Override
      public Builder addRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          java.lang.Object value) {
        return super.addRepeatedField(field, value);
      }
      @java.lang.Override
      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof com.nagpal.bala.playgroundapp.protobuf.generated.EnumurationsOuterClass.Enumurations) {
          return mergeFrom((com.nagpal.bala.playgroundapp.protobuf.generated.EnumurationsOuterClass.Enumurations)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(com.nagpal.bala.playgroundapp.protobuf.generated.EnumurationsOuterClass.Enumurations other) {
        if (other == com.nagpal.bala.playgroundapp.protobuf.generated.EnumurationsOuterClass.Enumurations.getDefaultInstance()) return this;
        if (other.eyeColor_ != 0) {
          setEyeColorValue(other.getEyeColorValue());
        }
        this.mergeUnknownFields(other.unknownFields);
        onChanged();
        return this;
      }

      @java.lang.Override
      public final boolean isInitialized() {
        return true;
      }

      @java.lang.Override
      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        com.nagpal.bala.playgroundapp.protobuf.generated.EnumurationsOuterClass.Enumurations parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (com.nagpal.bala.playgroundapp.protobuf.generated.EnumurationsOuterClass.Enumurations) e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }

      private int eyeColor_ = 0;
      /**
       * <code>.com.nagpal.bala.playgroundapp.protobuf.generated.EYE_COLOR eye_color = 1;</code>
       * @return The enum numeric value on the wire for eyeColor.
       */
      @java.lang.Override public int getEyeColorValue() {
        return eyeColor_;
      }
      /**
       * <code>.com.nagpal.bala.playgroundapp.protobuf.generated.EYE_COLOR eye_color = 1;</code>
       * @param value The enum numeric value on the wire for eyeColor to set.
       * @return This builder for chaining.
       */
      public Builder setEyeColorValue(int value) {
        
        eyeColor_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>.com.nagpal.bala.playgroundapp.protobuf.generated.EYE_COLOR eye_color = 1;</code>
       * @return The eyeColor.
       */
      @java.lang.Override
      public com.nagpal.bala.playgroundapp.protobuf.generated.EnumurationsOuterClass.EYE_COLOR getEyeColor() {
        @SuppressWarnings("deprecation")
        com.nagpal.bala.playgroundapp.protobuf.generated.EnumurationsOuterClass.EYE_COLOR result = com.nagpal.bala.playgroundapp.protobuf.generated.EnumurationsOuterClass.EYE_COLOR.valueOf(eyeColor_);
        return result == null ? com.nagpal.bala.playgroundapp.protobuf.generated.EnumurationsOuterClass.EYE_COLOR.UNRECOGNIZED : result;
      }
      /**
       * <code>.com.nagpal.bala.playgroundapp.protobuf.generated.EYE_COLOR eye_color = 1;</code>
       * @param value The eyeColor to set.
       * @return This builder for chaining.
       */
      public Builder setEyeColor(com.nagpal.bala.playgroundapp.protobuf.generated.EnumurationsOuterClass.EYE_COLOR value) {
        if (value == null) {
          throw new NullPointerException();
        }
        
        eyeColor_ = value.getNumber();
        onChanged();
        return this;
      }
      /**
       * <code>.com.nagpal.bala.playgroundapp.protobuf.generated.EYE_COLOR eye_color = 1;</code>
       * @return This builder for chaining.
       */
      public Builder clearEyeColor() {
        
        eyeColor_ = 0;
        onChanged();
        return this;
      }
      @java.lang.Override
      public final Builder setUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return super.setUnknownFields(unknownFields);
      }

      @java.lang.Override
      public final Builder mergeUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return super.mergeUnknownFields(unknownFields);
      }


      // @@protoc_insertion_point(builder_scope:com.nagpal.bala.playgroundapp.protobuf.generated.Enumurations)
    }

    // @@protoc_insertion_point(class_scope:com.nagpal.bala.playgroundapp.protobuf.generated.Enumurations)
    private static final com.nagpal.bala.playgroundapp.protobuf.generated.EnumurationsOuterClass.Enumurations DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new com.nagpal.bala.playgroundapp.protobuf.generated.EnumurationsOuterClass.Enumurations();
    }

    public static com.nagpal.bala.playgroundapp.protobuf.generated.EnumurationsOuterClass.Enumurations getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<Enumurations>
        PARSER = new com.google.protobuf.AbstractParser<Enumurations>() {
      @java.lang.Override
      public Enumurations parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
        return new Enumurations(input, extensionRegistry);
      }
    };

    public static com.google.protobuf.Parser<Enumurations> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<Enumurations> getParserForType() {
      return PARSER;
    }

    @java.lang.Override
    public com.nagpal.bala.playgroundapp.protobuf.generated.EnumurationsOuterClass.Enumurations getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_nagpal_bala_playgroundapp_protobuf_generated_Enumurations_descriptor;
  private static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_nagpal_bala_playgroundapp_protobuf_generated_Enumurations_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\022enumurations.proto\0220com.nagpal.bala.pl" +
      "aygroundapp.protobuf.generated\"^\n\014Enumur" +
      "ations\022N\n\teye_color\030\001 \001(\0162;.com.nagpal.b" +
      "ala.playgroundapp.protobuf.generated.EYE" +
      "_COLOR*b\n\tEYE_COLOR\022\027\n\023EYE_COLOR_UNDEFIN" +
      "ED\020\000\022\022\n\016EYE_COLOR_BLUE\020\001\022\023\n\017EYE_COLOR_GR" +
      "EEN\020\002\022\023\n\017EYE_COLOR_BROWN\020\003b\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_com_nagpal_bala_playgroundapp_protobuf_generated_Enumurations_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_com_nagpal_bala_playgroundapp_protobuf_generated_Enumurations_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_nagpal_bala_playgroundapp_protobuf_generated_Enumurations_descriptor,
        new java.lang.String[] { "EyeColor", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
