// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: simple.proto

public final class SimpleOuterClass {
  private SimpleOuterClass() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  public interface SimpleOrBuilder extends
      // @@protoc_insertion_point(interface_extends:Simple)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>uint32 id = 1;</code>
     * @return The id.
     */
    int getId();

    /**
     * <code>bool is_simple = 2;</code>
     * @return The isSimple.
     */
    boolean getIsSimple();

    /**
     * <code>string name = 3;</code>
     * @return The name.
     */
    java.lang.String getName();
    /**
     * <code>string name = 3;</code>
     * @return The bytes for name.
     */
    com.google.protobuf.ByteString
        getNameBytes();

    /**
     * <code>repeated uint32 sample_list = 4;</code>
     * @return A list containing the sampleList.
     */
    java.util.List<java.lang.Integer> getSampleListList();
    /**
     * <code>repeated uint32 sample_list = 4;</code>
     * @return The count of sampleList.
     */
    int getSampleListCount();
    /**
     * <code>repeated uint32 sample_list = 4;</code>
     * @param index The index of the element to return.
     * @return The sampleList at the given index.
     */
    int getSampleList(int index);
  }
  /**
   * Protobuf type {@code Simple}
   */
  public static final class Simple extends
      com.google.protobuf.GeneratedMessageV3 implements
      // @@protoc_insertion_point(message_implements:Simple)
      SimpleOrBuilder {
  private static final long serialVersionUID = 0L;
    // Use Simple.newBuilder() to construct.
    private Simple(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }
    private Simple() {
      name_ = "";
      sampleList_ = emptyIntList();
    }

    @java.lang.Override
    @SuppressWarnings({"unused"})
    protected java.lang.Object newInstance(
        UnusedPrivateParameter unused) {
      return new Simple();
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return this.unknownFields;
    }
    private Simple(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      this();
      if (extensionRegistry == null) {
        throw new java.lang.NullPointerException();
      }
      int mutable_bitField0_ = 0;
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

              id_ = input.readUInt32();
              break;
            }
            case 16: {

              isSimple_ = input.readBool();
              break;
            }
            case 26: {
              java.lang.String s = input.readStringRequireUtf8();

              name_ = s;
              break;
            }
            case 32: {
              if (!((mutable_bitField0_ & 0x00000001) != 0)) {
                sampleList_ = newIntList();
                mutable_bitField0_ |= 0x00000001;
              }
              sampleList_.addInt(input.readUInt32());
              break;
            }
            case 34: {
              int length = input.readRawVarint32();
              int limit = input.pushLimit(length);
              if (!((mutable_bitField0_ & 0x00000001) != 0) && input.getBytesUntilLimit() > 0) {
                sampleList_ = newIntList();
                mutable_bitField0_ |= 0x00000001;
              }
              while (input.getBytesUntilLimit() > 0) {
                sampleList_.addInt(input.readUInt32());
              }
              input.popLimit(limit);
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
        if (((mutable_bitField0_ & 0x00000001) != 0)) {
          sampleList_.makeImmutable(); // C
        }
        this.unknownFields = unknownFields.build();
        makeExtensionsImmutable();
      }
    }
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return SimpleOuterClass.internal_static_Simple_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return SimpleOuterClass.internal_static_Simple_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              SimpleOuterClass.Simple.class, SimpleOuterClass.Simple.Builder.class);
    }

    public static final int ID_FIELD_NUMBER = 1;
    private int id_;
    /**
     * <code>uint32 id = 1;</code>
     * @return The id.
     */
    @java.lang.Override
    public int getId() {
      return id_;
    }

    public static final int IS_SIMPLE_FIELD_NUMBER = 2;
    private boolean isSimple_;
    /**
     * <code>bool is_simple = 2;</code>
     * @return The isSimple.
     */
    @java.lang.Override
    public boolean getIsSimple() {
      return isSimple_;
    }

    public static final int NAME_FIELD_NUMBER = 3;
    private volatile java.lang.Object name_;
    /**
     * <code>string name = 3;</code>
     * @return The name.
     */
    @java.lang.Override
    public java.lang.String getName() {
      java.lang.Object ref = name_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        name_ = s;
        return s;
      }
    }
    /**
     * <code>string name = 3;</code>
     * @return The bytes for name.
     */
    @java.lang.Override
    public com.google.protobuf.ByteString
        getNameBytes() {
      java.lang.Object ref = name_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        name_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int SAMPLE_LIST_FIELD_NUMBER = 4;
    private com.google.protobuf.Internal.IntList sampleList_;
    /**
     * <code>repeated uint32 sample_list = 4;</code>
     * @return A list containing the sampleList.
     */
    @java.lang.Override
    public java.util.List<java.lang.Integer>
        getSampleListList() {
      return sampleList_;
    }
    /**
     * <code>repeated uint32 sample_list = 4;</code>
     * @return The count of sampleList.
     */
    public int getSampleListCount() {
      return sampleList_.size();
    }
    /**
     * <code>repeated uint32 sample_list = 4;</code>
     * @param index The index of the element to return.
     * @return The sampleList at the given index.
     */
    public int getSampleList(int index) {
      return sampleList_.getInt(index);
    }
    private int sampleListMemoizedSerializedSize = -1;

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
      getSerializedSize();
      if (id_ != 0) {
        output.writeUInt32(1, id_);
      }
      if (isSimple_ != false) {
        output.writeBool(2, isSimple_);
      }
      if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(name_)) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 3, name_);
      }
      if (getSampleListList().size() > 0) {
        output.writeUInt32NoTag(34);
        output.writeUInt32NoTag(sampleListMemoizedSerializedSize);
      }
      for (int i = 0; i < sampleList_.size(); i++) {
        output.writeUInt32NoTag(sampleList_.getInt(i));
      }
      unknownFields.writeTo(output);
    }

    @java.lang.Override
    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (id_ != 0) {
        size += com.google.protobuf.CodedOutputStream
          .computeUInt32Size(1, id_);
      }
      if (isSimple_ != false) {
        size += com.google.protobuf.CodedOutputStream
          .computeBoolSize(2, isSimple_);
      }
      if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(name_)) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(3, name_);
      }
      {
        int dataSize = 0;
        for (int i = 0; i < sampleList_.size(); i++) {
          dataSize += com.google.protobuf.CodedOutputStream
            .computeUInt32SizeNoTag(sampleList_.getInt(i));
        }
        size += dataSize;
        if (!getSampleListList().isEmpty()) {
          size += 1;
          size += com.google.protobuf.CodedOutputStream
              .computeInt32SizeNoTag(dataSize);
        }
        sampleListMemoizedSerializedSize = dataSize;
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
      if (!(obj instanceof SimpleOuterClass.Simple)) {
        return super.equals(obj);
      }
      SimpleOuterClass.Simple other = (SimpleOuterClass.Simple) obj;

      if (getId()
          != other.getId()) return false;
      if (getIsSimple()
          != other.getIsSimple()) return false;
      if (!getName()
          .equals(other.getName())) return false;
      if (!getSampleListList()
          .equals(other.getSampleListList())) return false;
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
      hash = (37 * hash) + ID_FIELD_NUMBER;
      hash = (53 * hash) + getId();
      hash = (37 * hash) + IS_SIMPLE_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashBoolean(
          getIsSimple());
      hash = (37 * hash) + NAME_FIELD_NUMBER;
      hash = (53 * hash) + getName().hashCode();
      if (getSampleListCount() > 0) {
        hash = (37 * hash) + SAMPLE_LIST_FIELD_NUMBER;
        hash = (53 * hash) + getSampleListList().hashCode();
      }
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static SimpleOuterClass.Simple parseFrom(
        java.nio.ByteBuffer data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static SimpleOuterClass.Simple parseFrom(
        java.nio.ByteBuffer data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static SimpleOuterClass.Simple parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static SimpleOuterClass.Simple parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static SimpleOuterClass.Simple parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static SimpleOuterClass.Simple parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static SimpleOuterClass.Simple parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static SimpleOuterClass.Simple parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }
    public static SimpleOuterClass.Simple parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input);
    }
    public static SimpleOuterClass.Simple parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static SimpleOuterClass.Simple parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static SimpleOuterClass.Simple parseFrom(
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
    public static Builder newBuilder(SimpleOuterClass.Simple prototype) {
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
     * Protobuf type {@code Simple}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:Simple)
        SimpleOuterClass.SimpleOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return SimpleOuterClass.internal_static_Simple_descriptor;
      }

      @java.lang.Override
      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return SimpleOuterClass.internal_static_Simple_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                SimpleOuterClass.Simple.class, SimpleOuterClass.Simple.Builder.class);
      }

      // Construct using SimpleOuterClass.Simple.newBuilder()
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
        id_ = 0;

        isSimple_ = false;

        name_ = "";

        sampleList_ = emptyIntList();
        bitField0_ = (bitField0_ & ~0x00000001);
        return this;
      }

      @java.lang.Override
      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return SimpleOuterClass.internal_static_Simple_descriptor;
      }

      @java.lang.Override
      public SimpleOuterClass.Simple getDefaultInstanceForType() {
        return SimpleOuterClass.Simple.getDefaultInstance();
      }

      @java.lang.Override
      public SimpleOuterClass.Simple build() {
        SimpleOuterClass.Simple result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      @java.lang.Override
      public SimpleOuterClass.Simple buildPartial() {
        SimpleOuterClass.Simple result = new SimpleOuterClass.Simple(this);
        int from_bitField0_ = bitField0_;
        result.id_ = id_;
        result.isSimple_ = isSimple_;
        result.name_ = name_;
        if (((bitField0_ & 0x00000001) != 0)) {
          sampleList_.makeImmutable();
          bitField0_ = (bitField0_ & ~0x00000001);
        }
        result.sampleList_ = sampleList_;
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
        if (other instanceof SimpleOuterClass.Simple) {
          return mergeFrom((SimpleOuterClass.Simple)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(SimpleOuterClass.Simple other) {
        if (other == SimpleOuterClass.Simple.getDefaultInstance()) return this;
        if (other.getId() != 0) {
          setId(other.getId());
        }
        if (other.getIsSimple() != false) {
          setIsSimple(other.getIsSimple());
        }
        if (!other.getName().isEmpty()) {
          name_ = other.name_;
          onChanged();
        }
        if (!other.sampleList_.isEmpty()) {
          if (sampleList_.isEmpty()) {
            sampleList_ = other.sampleList_;
            bitField0_ = (bitField0_ & ~0x00000001);
          } else {
            ensureSampleListIsMutable();
            sampleList_.addAll(other.sampleList_);
          }
          onChanged();
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
        SimpleOuterClass.Simple parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (SimpleOuterClass.Simple) e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }
      private int bitField0_;

      private int id_ ;
      /**
       * <code>uint32 id = 1;</code>
       * @return The id.
       */
      @java.lang.Override
      public int getId() {
        return id_;
      }
      /**
       * <code>uint32 id = 1;</code>
       * @param value The id to set.
       * @return This builder for chaining.
       */
      public Builder setId(int value) {
        
        id_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>uint32 id = 1;</code>
       * @return This builder for chaining.
       */
      public Builder clearId() {
        
        id_ = 0;
        onChanged();
        return this;
      }

      private boolean isSimple_ ;
      /**
       * <code>bool is_simple = 2;</code>
       * @return The isSimple.
       */
      @java.lang.Override
      public boolean getIsSimple() {
        return isSimple_;
      }
      /**
       * <code>bool is_simple = 2;</code>
       * @param value The isSimple to set.
       * @return This builder for chaining.
       */
      public Builder setIsSimple(boolean value) {
        
        isSimple_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>bool is_simple = 2;</code>
       * @return This builder for chaining.
       */
      public Builder clearIsSimple() {
        
        isSimple_ = false;
        onChanged();
        return this;
      }

      private java.lang.Object name_ = "";
      /**
       * <code>string name = 3;</code>
       * @return The name.
       */
      public java.lang.String getName() {
        java.lang.Object ref = name_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          name_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string name = 3;</code>
       * @return The bytes for name.
       */
      public com.google.protobuf.ByteString
          getNameBytes() {
        java.lang.Object ref = name_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          name_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string name = 3;</code>
       * @param value The name to set.
       * @return This builder for chaining.
       */
      public Builder setName(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  
        name_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string name = 3;</code>
       * @return This builder for chaining.
       */
      public Builder clearName() {
        
        name_ = getDefaultInstance().getName();
        onChanged();
        return this;
      }
      /**
       * <code>string name = 3;</code>
       * @param value The bytes for name to set.
       * @return This builder for chaining.
       */
      public Builder setNameBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
        
        name_ = value;
        onChanged();
        return this;
      }

      private com.google.protobuf.Internal.IntList sampleList_ = emptyIntList();
      private void ensureSampleListIsMutable() {
        if (!((bitField0_ & 0x00000001) != 0)) {
          sampleList_ = mutableCopy(sampleList_);
          bitField0_ |= 0x00000001;
         }
      }
      /**
       * <code>repeated uint32 sample_list = 4;</code>
       * @return A list containing the sampleList.
       */
      public java.util.List<java.lang.Integer>
          getSampleListList() {
        return ((bitField0_ & 0x00000001) != 0) ?
                 java.util.Collections.unmodifiableList(sampleList_) : sampleList_;
      }
      /**
       * <code>repeated uint32 sample_list = 4;</code>
       * @return The count of sampleList.
       */
      public int getSampleListCount() {
        return sampleList_.size();
      }
      /**
       * <code>repeated uint32 sample_list = 4;</code>
       * @param index The index of the element to return.
       * @return The sampleList at the given index.
       */
      public int getSampleList(int index) {
        return sampleList_.getInt(index);
      }
      /**
       * <code>repeated uint32 sample_list = 4;</code>
       * @param index The index to set the value at.
       * @param value The sampleList to set.
       * @return This builder for chaining.
       */
      public Builder setSampleList(
          int index, int value) {
        ensureSampleListIsMutable();
        sampleList_.setInt(index, value);
        onChanged();
        return this;
      }
      /**
       * <code>repeated uint32 sample_list = 4;</code>
       * @param value The sampleList to add.
       * @return This builder for chaining.
       */
      public Builder addSampleList(int value) {
        ensureSampleListIsMutable();
        sampleList_.addInt(value);
        onChanged();
        return this;
      }
      /**
       * <code>repeated uint32 sample_list = 4;</code>
       * @param values The sampleList to add.
       * @return This builder for chaining.
       */
      public Builder addAllSampleList(
          java.lang.Iterable<? extends java.lang.Integer> values) {
        ensureSampleListIsMutable();
        com.google.protobuf.AbstractMessageLite.Builder.addAll(
            values, sampleList_);
        onChanged();
        return this;
      }
      /**
       * <code>repeated uint32 sample_list = 4;</code>
       * @return This builder for chaining.
       */
      public Builder clearSampleList() {
        sampleList_ = emptyIntList();
        bitField0_ = (bitField0_ & ~0x00000001);
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


      // @@protoc_insertion_point(builder_scope:Simple)
    }

    // @@protoc_insertion_point(class_scope:Simple)
    private static final SimpleOuterClass.Simple DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new SimpleOuterClass.Simple();
    }

    public static SimpleOuterClass.Simple getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<Simple>
        PARSER = new com.google.protobuf.AbstractParser<Simple>() {
      @java.lang.Override
      public Simple parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
        return new Simple(input, extensionRegistry);
      }
    };

    public static com.google.protobuf.Parser<Simple> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<Simple> getParserForType() {
      return PARSER;
    }

    @java.lang.Override
    public SimpleOuterClass.Simple getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Simple_descriptor;
  private static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Simple_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\014simple.proto\"J\n\006Simple\022\n\n\002id\030\001 \001(\r\022\021\n\t" +
      "is_simple\030\002 \001(\010\022\014\n\004name\030\003 \001(\t\022\023\n\013sample_" +
      "list\030\004 \003(\rb\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_Simple_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_Simple_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Simple_descriptor,
        new java.lang.String[] { "Id", "IsSimple", "Name", "SampleList", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
