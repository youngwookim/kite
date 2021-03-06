/**
 * Copyright 2013 Cloudera Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.kitesdk.data.hbase.avro;

import org.kitesdk.data.SchemaValidationException;

import org.junit.Test;

public class AvroKeyEntitySchemaParserTest {

  private static final AvroKeyEntitySchemaParser parser = new AvroKeyEntitySchemaParser();

  @Test
  public void testGoodSchema() {
    parser.parseEntitySchema(AvroUtils
        .inputStreamToString(AvroKeyEntitySchemaParserTest.class
            .getResourceAsStream("/TestRecord.avsc")));
  }

  @Test(expected = SchemaValidationException.class)
  public void testBadSchemaMultipleOCCVersions() {
    parser.parseEntitySchema(AvroUtils
        .inputStreamToString(AvroKeyEntitySchemaParser.class
            .getResourceAsStream("/BadSchemaMultipleOCCVersions.avsc")));
  }

  @Test(expected = SchemaValidationException.class)
  public void testBadSchemaOCCVersionAndCounter() {
    parser.parseEntitySchema(AvroUtils
        .inputStreamToString(AvroKeyEntitySchemaParser.class
            .getResourceAsStream("/BadSchemaOCCVersionAndCounter.avsc")));
  }
}
