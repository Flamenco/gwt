/*
 * Copyright 2008 Google Inc.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.google.gwt.user.client.rpc.core.java.util;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;
import java.util.Map.Entry;

/**
 * Custom field serializer for {@link java.util.TreeMap}.
 */
@SuppressWarnings("unchecked")
public class TreeSet_CustomFieldSerializer {

  /* for now, build it entry by entry. Can optimize later via bulk loading */
  public static void deserialize(SerializationStreamReader streamReader,
      TreeSet instance) throws SerializationException {
    int size = streamReader.readInt();
    for (int i = 0; i < size; ++i) {
      instance.add(streamReader.readObject());
    }
  }

  public static TreeSet instantiate(SerializationStreamReader streamReader)
      throws SerializationException {
    return new TreeSet((Comparator) streamReader.readObject());
  }

  public static void serialize(SerializationStreamWriter streamWriter,
      TreeSet instance) throws SerializationException {
    streamWriter.writeObject(instance.comparator());
    streamWriter.writeInt(instance.size());
    for (Object entry :  instance) {
      streamWriter.writeObject(entry);
    }
  }
}
