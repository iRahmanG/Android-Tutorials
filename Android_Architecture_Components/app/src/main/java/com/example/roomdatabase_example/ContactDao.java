package com.example.roomdatabase_example;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.room.EntityDeleteOrUpdateAdapter;
import androidx.room.EntityInsertAdapter;
import androidx.room.RoomDatabase;
import androidx.room.util.DBUtil;
import androidx.room.util.SQLiteStatementUtil;
import androidx.sqlite.SQLiteStatement;
import java.lang.Class;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation", "removal"})
public final class ContactDao_Impl implements ContactDao {
  private final RoomDatabase __db;

  private final EntityInsertAdapter<Contact> __insertAdapterOfContact;

  private final Convertors __convertors = new Convertors();

  private final EntityDeleteOrUpdateAdapter<Contact> __deleteAdapterOfContact;

  private final EntityDeleteOrUpdateAdapter<Contact> __updateAdapterOfContact;

  public ContactDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertAdapterOfContact = new EntityInsertAdapter<Contact>() {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR ABORT INTO `contacts` (`id`,`name`,`phoneNumber`,`createdDate`,`isActive`) VALUES (nullif(?, 0),?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SQLiteStatement statement, @NonNull final Contact entity) {
        statement.bindLong(1, entity.getId());
        if (entity.getName() == null) {
          statement.bindNull(2);
        } else {
          statement.bindText(2, entity.getName());
        }
        if (entity.getPhoneNumber() == null) {
          statement.bindNull(3);
        } else {
          statement.bindText(3, entity.getPhoneNumber());
        }
        final long _tmp = __convertors.fromDateToLong(entity.getCreatedDate());
        statement.bindLong(4, _tmp);
        statement.bindLong(5, entity.isActive());
      }
    };
    this.__deleteAdapterOfContact = new EntityDeleteOrUpdateAdapter<Contact>() {
      @Override
      @NonNull
      protected String createQuery() {
        return "DELETE FROM `contacts` WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SQLiteStatement statement, @NonNull final Contact entity) {
        statement.bindLong(1, entity.getId());
      }
    };
    this.__updateAdapterOfContact = new EntityDeleteOrUpdateAdapter<Contact>() {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE OR ABORT `contacts` SET `id` = ?,`name` = ?,`phoneNumber` = ?,`createdDate` = ?,`isActive` = ? WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SQLiteStatement statement, @NonNull final Contact entity) {
        statement.bindLong(1, entity.getId());
        if (entity.getName() == null) {
          statement.bindNull(2);
        } else {
          statement.bindText(2, entity.getName());
        }
        if (entity.getPhoneNumber() == null) {
          statement.bindNull(3);
        } else {
          statement.bindText(3, entity.getPhoneNumber());
        }
        final long _tmp = __convertors.fromDateToLong(entity.getCreatedDate());
        statement.bindLong(4, _tmp);
        statement.bindLong(5, entity.isActive());
        statement.bindLong(6, entity.getId());
      }
    };
  }

  @Override
  public void insertContact(final Contact contact) {
    if (contact == null) throw new NullPointerException();
    DBUtil.performBlocking(__db, false, true, (_connection) -> {
      __insertAdapterOfContact.insert(_connection, contact);
      return null;
    });
  }

  @Override
  public void deleteContact(final Contact contact) {
    if (contact == null) throw new NullPointerException();
    DBUtil.performBlocking(__db, false, true, (_connection) -> {
      __deleteAdapterOfContact.handle(_connection, contact);
      return null;
    });
  }

  @Override
  public void updateContact(final Contact contact) {
    if (contact == null) throw new NullPointerException();
    DBUtil.performBlocking(__db, false, true, (_connection) -> {
      __updateAdapterOfContact.handle(_connection, contact);
      return null;
    });
  }

  @Override
  public LiveData<List<Contact>> getContacts() {
    final String _sql = "SELECT * FROM contacts";
    return __db.getInvalidationTracker().createLiveData(new String[] {"contacts"}, false, (_connection) -> {
      final SQLiteStatement _stmt = _connection.prepare(_sql);
      try {
        final int _columnIndexOfId = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "id");
        final int _columnIndexOfName = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "name");
        final int _columnIndexOfPhoneNumber = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "phoneNumber");
        final int _columnIndexOfCreatedDate = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "createdDate");
        final int _columnIndexOfIsActive = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "isActive");
        final List<Contact> _result = new ArrayList<Contact>();
        while (_stmt.step()) {
          final Contact _item;
          final long _tmpId;
          _tmpId = _stmt.getLong(_columnIndexOfId);
          final String _tmpName;
          if (_stmt.isNull(_columnIndexOfName)) {
            _tmpName = null;
          } else {
            _tmpName = _stmt.getText(_columnIndexOfName);
          }
          final String _tmpPhoneNumber;
          if (_stmt.isNull(_columnIndexOfPhoneNumber)) {
            _tmpPhoneNumber = null;
          } else {
            _tmpPhoneNumber = _stmt.getText(_columnIndexOfPhoneNumber);
          }
          final Date _tmpCreatedDate;
          final long _tmp;
          _tmp = _stmt.getLong(_columnIndexOfCreatedDate);
          _tmpCreatedDate = __convertors.fromDateToLong(_tmp);
          final int _tmpIsActive;
          _tmpIsActive = (int) (_stmt.getLong(_columnIndexOfIsActive));
          _item = new Contact(_tmpId,_tmpName,_tmpPhoneNumber,_tmpCreatedDate,_tmpIsActive);
          _result.add(_item);
        }
        return _result;
      } finally {
        _stmt.close();
      }
    });
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
