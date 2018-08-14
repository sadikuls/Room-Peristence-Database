package com.sadikul.stepstoroom.Persistence;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.sadikul.stepstoroom.Persistence.Dao.UserDao;
import com.sadikul.stepstoroom.Persistence.User_Table.User;

/*created room database by extending RoomDatabase class . This is an abstract class that contains
abstract method that will return dao object
*/
@Database(entities = {User.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract UserDao userDao();
    public static AppDatabase mInstance;

    public static AppDatabase getDatabase(Context context) {
        if (mInstance == null) {
            synchronized (AppDatabase.class) {
                if (mInstance == null) {
                    mInstance = Room.databaseBuilder(context.getApplicationContext(),
                            AppDatabase.class, "sadikuls_database")
                            .build();

                }
            }
        }
        return mInstance;
    }

   /* private static RoomDatabase.Callback sRoomDatabaseCallback =
            new RoomDatabase.Callback(){

                @Override
                public void onOpen (@NonNull SupportSQLiteDatabase db){
                    super.onOpen(db);
                    new PopulateDbAsync(mInstance).execute();
                }
            };


    private static class PopulateDbAsync extends AsyncTask<Void, Void, Void> {

        private final UserDao mDao;

        PopulateDbAsync(AppDatabase db) {
            mDao = db.userDao();
        }

        @Override
        protected Void doInBackground(final Void... params) {
            mDao.deleteAll();
            User user = new User("Hello","default@mail.com");
            mDao.insertUser(user);
            return null;
        }
    }*/
}
